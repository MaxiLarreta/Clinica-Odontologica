package com.dh.clinica.service;

import com.dh.clinica.model.Odontologo;
import com.dh.clinica.model.Paciente;


import java.util.List;
import java.util.Optional;

public interface IOdontologoService {

    public Odontologo registrarOdontologo(Odontologo odontologo);

    public void eliminar(Integer id);

    public Optional<Odontologo> buscar(Integer id);

    public List<Odontologo> buscarTodos();

    public Odontologo actualizar(Odontologo odontologo);

    public Optional<Odontologo> findByMatricula(Integer matricula);
}
