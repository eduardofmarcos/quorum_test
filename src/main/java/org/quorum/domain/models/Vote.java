package org.quorum.domain.models;

import com.opencsv.bean.CsvBindByName;
import java.util.Objects;

public class Vote {

  @CsvBindByName(column = "id")
  private int id;
  @CsvBindByName(column = "bill_id")
  private int billId;

  public Vote() {
  }

  public Vote(int id, int billId) {
    this.id = id;
    this.billId = billId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getBillId() {
    return billId;
  }

  public void setBillId(int billId) {
    this.billId = billId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vote vote = (Vote) o;
    return getId() == vote.getId() && getBillId() == vote.getBillId();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getBillId());
  }

  @Override
  public String toString() {
    return "Vote{" +
        "id=" + id +
        ", billId=" + billId +
        '}';
  }
}