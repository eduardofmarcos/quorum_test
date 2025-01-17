package org.quorum.domain.models;

import com.opencsv.bean.CsvBindByName;
import java.util.Objects;

public class VoteResult {

  @CsvBindByName(column = "id")
  private int id;
  @CsvBindByName(column = "legislator_id")
  private int legislatorId;
  @CsvBindByName(column = "vote_id")
  private int voteId;
  @CsvBindByName(column = "vote_type")
  private int voteType;

  public VoteResult() {
  }

  public VoteResult(int id, int legislatorId, int voteId, int voteType) {
    this.id = id;
    this.legislatorId = legislatorId;
    this.voteId = voteId;
    this.voteType = voteType;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getLegislatorId() {
    return legislatorId;
  }

  public void setLegislatorId(int legislatorId) {
    this.legislatorId = legislatorId;
  }

  public int getVoteId() {
    return voteId;
  }

  public void setVoteId(int voteId) {
    this.voteId = voteId;
  }

  public int getVoteType() {
    return voteType;
  }

  public void setVoteType(int voteType) {
    this.voteType = voteType;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoteResult that = (VoteResult) o;
    return getId() == that.getId() && getLegislatorId() == that.getLegislatorId()
        && getVoteId() == that.getVoteId() && getVoteType() == that.getVoteType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getLegislatorId(), getVoteId(), getVoteType());
  }

  @Override
  public String toString() {
    return "VoteResult{" +
        "id=" + id +
        ", legislatorId=" + legislatorId +
        ", voteId=" + voteId +
        ", voteType=" + voteType +
        '}';
  }
}
