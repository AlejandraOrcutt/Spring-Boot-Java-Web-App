package com.promineoFinal.repository;

import javax.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import com.promineoFinal.model.Group;

  @Table
  public interface GroupRepository extends JpaRepository<Group, Long>{

  }