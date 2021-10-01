package com.dh.clinica.controller;

import com.dh.clinica.model.ConsultaSemanaSiguienteDTO;
import com.dh.clinica.model.Turno;
import com.dh.clinica.model.TurnoDTO;
import com.dh.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Integer> registrarTurno(@RequestBody TurnoDTO turno) {
        ResponseEntity<Integer> response;
        try {
            Integer turnoID = this.turnoService.registrarTurno(turno);
            response = ResponseEntity.ok(turnoID);
            return response;
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return response;
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Integer id) {

        Turno turno = turnoService.buscar(id).get();
        return ResponseEntity.ok(new TurnoDTO(turno.getId(), turno.getPaciente().getDni(), turno.getOdontologo().getMatricula(), turno.getDate()));

    }

    @GetMapping("/siguienteSemana")
    public ResponseEntity<List<ConsultaSemanaSiguienteDTO>> buscarSiguienteSemana() {
        return ResponseEntity.ok(turnoService.buscarPorSemana());
    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listar() {
        return ResponseEntity.ok(turnoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (turnoService.buscar(id).isPresent()) {
            turnoService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<TurnoDTO> actualizarTurno(@RequestBody TurnoDTO turnoDTO) {
        ResponseEntity<Integer> response;
        try {
            this.turnoService.actualizar(turnoDTO);
            return ResponseEntity.ok(turnoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
