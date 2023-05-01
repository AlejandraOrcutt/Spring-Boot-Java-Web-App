package com.promineoFinal.repository;

import javax.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import com.promineoFinal.model.Instrument;


@Table
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

  Instrument findByName(String instrumentName);
}
