package com.dh.clinica.service;

import com.dh.clinica.model.*;
import com.dh.clinica.repository.impl.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

import static java.time.LocalDate.now;


@Service
public class TurnoService implements ITurnoService{

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;

    private final TurnoRepository turnoRepository;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Integer registrarTurno(TurnoDTO turnoDTO) throws Exception {
        return this.saveTurno(turnoDTO, false);
    }

    public Integer saveTurno(TurnoDTO turnoDTO, Boolean update) throws Exception {
        Paciente paciente = pacienteService.findByDni(turnoDTO.getPacienteDNI()).get();
        Odontologo odontologo = odontologoService.findByMatricula(turnoDTO.getOdontologoMatricula()).get();
        if (paciente != null && odontologo != null) {
            Turno turno = new Turno();
            if (update) {
                turno.setId(turnoDTO.getId());
            }
            turno.setPaciente(paciente);
            turno.setOdontologo(odontologo);
            turno.setDate(turnoDTO.getFecha());
            return this.turnoRepository.save(turno).getId();
        }
        throw new Exception("Paciente u Odontologo no encontrado.");
    }

    public List<TurnoDTO> listar(){
        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoDTO> turnosDTO = new ArrayList<TurnoDTO>();
        for(Turno turno : turnos) {
            TurnoDTO turnoDTO = new TurnoDTO(turno.getId(), turno.getPaciente().getDni(), turno.getOdontologo().getMatricula(), turno.getDate());
            turnosDTO.add(turnoDTO);
        }
        return turnosDTO;
    }

    public void eliminar(Integer id){
        turnoRepository.deleteById(Integer.valueOf(id));
    }

    public void actualizar(TurnoDTO turnoDTO) throws Exception {
        this.saveTurno(turnoDTO, true);
    }

    public Optional<Turno> buscar(Integer id) {
        return turnoRepository.findById(id);
    }

    public List<ConsultaSemanaSiguienteDTO> buscarPorSemana(){
        Calendar unaSemana = Calendar.getInstance();
        unaSemana.setTime(new Date());
        unaSemana.add(Calendar.DATE, 7);
        List<Turno> turnos = turnoRepository.findByDateBetween(new Date(), unaSemana.getTime());
        List<ConsultaSemanaSiguienteDTO> turnosSemanaSiguienteDTO = new ArrayList<>();
        for (Turno turno : turnos) {
            turnosSemanaSiguienteDTO.add(new ConsultaSemanaSiguienteDTO(turno.getOdontologo().getNombre(), turno.getOdontologo().getApellido(), turno.getPaciente().getNombre(), turno.getPaciente().getApellido(), turno.getDate()));
        }
        return turnosSemanaSiguienteDTO;
    }

}
