package com.dh.clinica.service;

import com.dh.clinica.model.Paciente;

import java.util.List;
import java.util.Optional;

public interface IPacienteService {

    public Paciente guardar(Paciente p);

    public Optional<Paciente> buscar(Integer id);

    public List<Paciente> buscarTodos();

    public void eliminar(Integer id);

    public Paciente actualizar(Paciente p);

    public Optional<Paciente> findByDni(String dni);
}
