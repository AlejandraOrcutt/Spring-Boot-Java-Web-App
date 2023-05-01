package com.promineoFinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "instruments")
public class Instrument {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "instrument_id")
  private int instrumentId;

  @Column(name = "name")
  @Enumerated(EnumType.STRING)
  private InstrumentName name;

  @OneToMany(mappedBy = "instrument", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Student> students = new ArrayList<>();
  
  public enum InstrumentName {
    violin, viola, cello;
  }
}
