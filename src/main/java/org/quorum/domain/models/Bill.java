package org.quorum.domain.models;

import com.opencsv.bean.CsvBindByName;
import java.util.Objects;

public class Bill {

  @CsvBindByName(column = "id")
  private int id;
  @CsvBindByName(column = "title")
  private String title;
  @CsvBindByName(column = "sponsor_id")
  private int primarySponsorId;

  public Bill() {
  }

  public Bill(int id, String title, int primarySponsorId) {
    this.id = id;
    this.title = title;
    this.primarySponsorId = primarySponsorId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPrimarySponsorId() {
    return primarySponsorId;
  }

  public void setPrimarySponsorId(int primarySponsorId) {
    this.primarySponsorId = primarySponsorId;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bill bill = (Bill) o;
    return getId() == bill.getId() && getPrimarySponsorId() == bill.getPrimarySponsorId()
        && Objects.equals(getTitle(), bill.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getTitle(), getPrimarySponsorId());
  }

  @Override
  public String toString() {
    return "Bill{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", primarySponsorId=" + primarySponsorId +
        '}';
  }
}