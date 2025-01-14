package com.imloadinqqq.consistency.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "habits")
public class Habit {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "date")
  private LocalDate currentDate;

  public Habit() {
    this.currentDate = LocalDate.now();
  }

  public Habit(Long id, String name, String description, LocalDate currentDate) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.currentDate = currentDate;
  }

  // getters
  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDate() {
    return currentDate;
  }

  // setters
  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format("%d, %s, %s, %s", id, name, description, currentDate);
  }
}
