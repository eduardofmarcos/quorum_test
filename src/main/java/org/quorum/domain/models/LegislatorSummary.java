package org.quorum.domain.models;

import java.util.Objects;

public class LegislatorSummary {

  private int id;
  private String name;
  private long supportedBills;
  private long opposedBills;

  public LegislatorSummary() {
  }

  public LegislatorSummary(int id, String name, long supportedBills, long opposedBills) {
    this.id = id;
    this.name = name;
    this.supportedBills = supportedBills;
    this.opposedBills = opposedBills;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getSupportedBills() {
    return supportedBills;
  }

  public void setSupportedBills(long supportedBills) {
    this.supportedBills = supportedBills;
  }

  public long getOpposedBills() {
    return opposedBills;
  }

  public void setOpposedBills(long opposedBills) {
    this.opposedBills = opposedBills;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LegislatorSummary that = (LegislatorSummary) o;
    return getId() == that.getId() && getSupportedBills() == that.getSupportedBills()
        && getOpposedBills() == that.getOpposedBills() && Objects.equals(getName(),
        that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSupportedBills(), getOpposedBills());
  }

  @Override
  public String toString() {
    return "LegislatorSummary{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", supportedBills=" + supportedBills +
        ", opposedBills=" + opposedBills +
        '}';
  }
}