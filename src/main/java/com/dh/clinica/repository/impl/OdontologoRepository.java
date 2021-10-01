package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OdontologoRepository extends JpaRepository<Odontologo, Integer> {
    Optional<Odontologo> findByMatricula(Integer matricula);
}
