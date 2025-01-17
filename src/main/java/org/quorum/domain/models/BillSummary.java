package org.quorum.domain.models;

public class BillSummary {

  private int id;
  private String title;
  private long supporters;
  private long opposers;
  private String primarySponsor;

  public BillSummary(int id, String title, long supporters, long opposers, String primarySponsor) {
    this.id = id;
    this.title = title;
    this.supporters = supporters;
    this.opposers = opposers;
    this.primarySponsor = primarySponsor;
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

  public long getSupporters() {
    return supporters;
  }

  public void setSupporters(long supporters) {
    this.supporters = supporters;
  }

  public long getOpposers() {
    return opposers;
  }

  public void setOpposers(long opposers) {
    this.opposers = opposers;
  }

  public String getPrimarySponsor() {
    return primarySponsor;
  }

  public void setPrimarySponsor(String primarySponsor) {
    this.primarySponsor = primarySponsor;
  }
}