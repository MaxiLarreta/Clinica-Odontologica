package com.dh.clinica;



import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;

import org.junit.Assert;


import org.junit.FixMethodOrder;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;
    @Autowired


    public void cargarDataSet() {

        Paciente p = pacienteService.guardar(new Paciente("Marcos", "Martinez", "88888888", new Date(), "domicilio"));

        Paciente p1 = pacienteService.guardar(new Paciente("Micaela", "Gimenez", "99999999", new Date(), "domicilio1"));

    }

    @Test
    public void agregarYBuscarPacienteTest() {
        this.cargarDataSet();

        Paciente p = pacienteService.guardar(new Paciente("Tomas", "Gonzales", "43252524", new Date(), "domicilio"));

        Assert.assertNotNull(pacienteService.buscar(p.getId()));
    }

    @Test
    public void eliminarPacienteTest() {
        pacienteService.eliminar(3);
        Assert.assertTrue(pacienteService.buscar(3).isEmpty());

    }

    @Test
    public void traerTodos() {
        List<Paciente> pacientes = pacienteService.buscarTodos();
        Assert.assertTrue(!pacientes.isEmpty());
        Assert.assertTrue(pacientes.size() == 2);
        System.out.println(pacientes);
    }


}
