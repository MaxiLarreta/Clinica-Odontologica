package com.dh.clinica.model;

import java.io.Serializable;
import java.util.Date;

public class TurnoDTO implements Serializable {

    private Integer id;
    private String pacienteDNI;
    private Integer odontologoMatricula;
    private Date fecha;

    public TurnoDTO(Integer id, String pacienteDNI, Integer odontologoMatricula, Date fecha) {
        this.id = id;
        this.pacienteDNI = pacienteDNI;
        this.odontologoMatricula = odontologoMatricula;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPacienteDNI() {
        return pacienteDNI;
    }

    public void setPacienteDNI(String pacienteDNI) {
        this.pacienteDNI = pacienteDNI;
    }

    public Integer getOdontologoMatricula() {
        return odontologoMatricula;
    }

    public void setOdontologoMatricula(Integer odontologoMatricula) {
        this.odontologoMatricula = odontologoMatricula;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
