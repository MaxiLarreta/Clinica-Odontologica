package com.dh.clinica.repository.impl;

import com.dh.clinica.model.AppUser;
import com.dh.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByDni(String dni);
}
