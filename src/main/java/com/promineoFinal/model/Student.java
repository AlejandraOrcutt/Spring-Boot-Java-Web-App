package com.promineoFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
  @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
  @Column(name = "student_id")
  private int studentId;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  // Joining instrument
  @ManyToOne
  private Instrument instrument;
  
  // Joining group
  @ManyToOne
  private Group group;

  private String grade;

  // Empty constructor for deserialization
  public Student() {
  }

  // Constructor that accepts a string value for the "name" field during deserialization
  public Student(String name) {
    this.name = name;
  }

  // Getter and setter methods for all fields
  public int getStudentId() {
   return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Instrument getInstrument() {
    return instrument;
  }

  public void setInstrument(Instrument instrument) {
    this.instrument = instrument;
  }

  public Group getGroup() {
    return group;
  }

  public void setGroup(Group group) {
    this.group = group;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

}
