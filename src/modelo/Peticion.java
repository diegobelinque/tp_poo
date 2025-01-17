package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Peticion implements Serializable {
    private Paciente paciente;
    private String obraSocial;
    private Date fechaCarga;
    private List<Practica> practicasAsociadas;
    private Date fechaEntrega;

    public Peticion(Paciente paciente, String obraSocial, Date fechaCarga, List<Practica> practicasAsociadas, Date fechaEntrega) {
        this.paciente = paciente;
        this.obraSocial = obraSocial;
        this.fechaCarga = fechaCarga;
        this.practicasAsociadas = practicasAsociadas;
        this.fechaEntrega = fechaEntrega;
    }

    // Getters y Setters
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
    public String getObraSocial() { return obraSocial; }
    public void setObraSocial(String obraSocial) { this.obraSocial = obraSocial; }
    public Date getFechaCarga() { return fechaCarga; }
    public void setFechaCarga(Date fechaCarga) { this.fechaCarga = fechaCarga; }
    public List<Practica> getPracticasAsociadas() { return practicasAsociadas; }
    public void setPracticasAsociadas(List<Practica> practicasAsociadas) { this.practicasAsociadas = practicasAsociadas; }
    public Date getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(Date fechaEntrega) { this.fechaEntrega = fechaEntrega; }
}
