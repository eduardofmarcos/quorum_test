package org.quorum.domain.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.quorum.domain.models.Bill;
import org.quorum.domain.models.Person;
import org.quorum.domain.models.Vote;
import org.quorum.domain.models.VoteResult;

/**
 * Service for managing data loading operations from configured CSV files. Provides methods to load
 * legislators, bills, votes, and vote results.
 */
@ApplicationScoped
public class DataService {

  @Inject
  CSVReaderService csvReaderService;

  /**
   * Path to the legislators CSV file, injected from application properties.
   */
  @Inject
  @ConfigProperty(name = "files.legislators.path")
  String legislatorsPath;

  /**
   * Path to the bills CSV file, injected from application properties.
   */
  @Inject
  @ConfigProperty(name = "files.bills.path")
  String billsPath;

  /**
   * Path to the votes CSV file, injected from application properties.
   */
  @Inject
  @ConfigProperty(name = "files.votes.path")
  String votesPath;

  /**
   * Path to the vote results CSV file, injected from application properties.
   */
  @Inject
  @ConfigProperty(name = "files.vote-results.path")
  String voteResultsPath;

  /**
   * Loads the list of legislators from the configured CSV file.
   *
   * @return a list of Person objects representing legislators
   */
  public List<Person> loadLegislators() {
    return csvReaderService.readCSV(legislatorsPath, Person.class);
  }

  /**
   * Loads the list of bills from the configured CSV file.
   *
   * @return a list of Bill objects
   */
  public List<Bill> loadBills() {
    return csvReaderService.readCSV(billsPath, Bill.class);
  }

  /**
   * Loads the list of votes from the configured CSV file.
   *
   * @return a list of Vote objects
   */
  public List<Vote> loadVotes() {
    return csvReaderService.readCSV(votesPath, Vote.class);
  }

  /**
   * Loads the list of vote results from the configured CSV file.
   *
   * @return a list of VoteResult objects
   */
  public List<VoteResult> loadVoteResults() {
    return csvReaderService.readCSV(voteResultsPath, VoteResult.class);
  }
}