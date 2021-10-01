package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
    List<Turno> findByDateBetween(Date from, Date to);


}
