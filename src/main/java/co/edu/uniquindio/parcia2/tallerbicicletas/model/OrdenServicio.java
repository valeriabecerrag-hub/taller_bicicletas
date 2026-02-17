package co.edu.uniquindio.parcia2.tallerbicicletas.model;

import java.sql.Time;
import java.util.Date;

public class OrdenServicio {
    private Date fechaIngreso;
    private Time hora;
    private String diagnostico;
    private String trabajos;
    private double costoTotal;

    public OrdenServicio() {
    }

    public OrdenServicio(Date fechaIngreso,
                         Time hora,
                         String diagnostico,
                         String trabajos,
                         double costoTotal) {
        this.fechaIngreso = fechaIngreso;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.trabajos = trabajos;
        this.costoTotal = costoTotal;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(String trabajos) {
        this.trabajos = trabajos;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
