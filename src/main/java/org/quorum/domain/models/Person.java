package org.quorum.domain.models;

import com.opencsv.bean.CsvBindByName;
import java.util.Objects;

public class Person {

  @CsvBindByName(column = "id")
  private int id;
  @CsvBindByName(column = "name")
  private String name;

  public Person() {
  }

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return getId() == person.getId() && Objects.equals(getName(), person.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName());
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
