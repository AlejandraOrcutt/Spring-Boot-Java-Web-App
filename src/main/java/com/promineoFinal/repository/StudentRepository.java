package com.promineoFinal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.promineoFinal.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find all students by their name
    List<Student> findByName(String name);
    
    // Find all students by instrument name
    List<Student> findByInstrumentName(String instrumentName);

    List<Student> findByNameContainingIgnoreCase(String name);

}
