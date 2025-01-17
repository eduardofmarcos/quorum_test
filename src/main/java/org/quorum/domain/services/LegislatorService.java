package org.quorum.domain.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.quorum.domain.models.LegislatorSummary;
import org.quorum.domain.models.Person;
import org.quorum.domain.models.VoteResult;

@ApplicationScoped
public class LegislatorService {

  @Inject
  DataService dataService;

  public Map<Integer, Map<String, Long>> calculateVotesByLegislator() {
    List<VoteResult> voteResults = dataService.loadVoteResults();

    return voteResults.stream()
        .collect(Collectors.groupingBy(
            VoteResult::getLegislatorId,
            Collectors.groupingBy(
                vr -> vr.getVoteType() == 1 ? "supported" : "opposed",
                Collectors.counting()
            )
        ));
  }

  public List<LegislatorSummary> calculateLegislatorSummaries() {
    List<Person> legislators = dataService.loadLegislators();

    return legislators.stream()
        .map(legislator -> {
          Map<String, Long> voteCounts = calculateVotesByLegislator().getOrDefault(
              legislator.getId(), Map.of());
          long supportedBills = voteCounts.getOrDefault("supported", 0L);
          long opposedBills = voteCounts.getOrDefault("opposed", 0L);

          return new LegislatorSummary(legislator.getId(), legislator.getName(), supportedBills,
              opposedBills);
        })
        .collect(Collectors.toList());
  }

  public List<LegislatorSummary> searchLegislatorsByName(String name) {
    List<LegislatorSummary> summaries = calculateLegislatorSummaries();

    return summaries.stream()
        .filter(summary -> summary.getName().toLowerCase().contains(name.toLowerCase()))
        .collect(Collectors.toList());
  }

}