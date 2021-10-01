package com.dh.clinica.service;

import com.dh.clinica.model.ConsultaSemanaSiguienteDTO;
import com.dh.clinica.model.Turno;
import com.dh.clinica.model.TurnoDTO;

import java.util.List;
import java.util.Optional;

public interface ITurnoService {

    public Integer registrarTurno(TurnoDTO turnoDTO) throws Exception;
    public List<TurnoDTO> listar();
    public void eliminar(Integer id);
    public void actualizar(TurnoDTO turno) throws Exception;
    public Optional <Turno> buscar(Integer id);
    public List<ConsultaSemanaSiguienteDTO> buscarPorSemana();
}
