package org.quorum.domain.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.quorum.domain.models.Bill;
import org.quorum.domain.models.BillSummary;
import org.quorum.domain.models.Person;
import org.quorum.domain.models.Vote;
import org.quorum.domain.models.VoteResult;

/**
 * Service class responsible for operations related to Bills. It calculates summaries and manages
 * the mapping between Votes and Bills.
 */
@ApplicationScoped
public class BillService {

  @Inject
  DataService dataService;

  /**
   * Calculates summaries for all Bills, including the number of supporters, opposers, and
   * identifying the primary sponsor.
   *
   * @return a list of BillSummary objects
   */
  public List<BillSummary> calculateBillSummaries() {

    List<VoteResult> voteResults = dataService.loadVoteResults();
    List<Vote> votes = dataService.loadVotes();
    List<Person> legislators = dataService.loadLegislators();
    List<Bill> bills = dataService.loadBills();

    Map<Integer, Integer> voteToBillMap = createVoteToBillMap(votes);

    Map<Integer, Map<String, Long>> votesByBill = voteResults.stream()
        .collect(Collectors.groupingBy(
            vr -> voteToBillMap.getOrDefault(vr.getVoteId(), -1),
            Collectors.groupingBy(
                vr -> vr.getVoteType() == 1 ? "supporters" : "opposers",
                Collectors.counting()
            )
        ));

    return bills.stream()
        .map(bill -> {
          Map<String, Long> voteCounts = votesByBill.getOrDefault(bill.getId(), Map.of());
          long supporters = voteCounts.getOrDefault("supporters", 0L);
          long opposers = voteCounts.getOrDefault("opposers", 0L);

          String primarySponsor = legislators.stream()
              .filter(person -> person.getId() == bill.getPrimarySponsorId())
              .map(Person::getName)
              .findFirst()
              .orElse("Unknown");

          return new BillSummary(bill.getId(), bill.getTitle(), supporters, opposers,
              primarySponsor);
        })
        .collect(Collectors.toList());
  }

  /**
   * Creates a map associating voteId with billId, resolving any duplicate voteIds.
   *
   * @param votes the list of Votes to process
   * @return a map where keys are voteIds and values are billIds
   */
  public Map<Integer, Integer> createVoteToBillMap(List<Vote> votes) {
    Map<Integer, List<Vote>> groupedVotes = votes.stream()
        .collect(Collectors.groupingBy(Vote::getId));

    groupedVotes.forEach((key, value) -> {
      if (value.size() > 1) {
        System.out.println("Duplicate voteId: " + key + " -> " + value);
      }
    });

    return votes.stream()
        .collect(Collectors.toMap(
            Vote::getId,
            Vote::getBillId,
            (existing, replacement) -> existing
        ));
  }
}