package modelo;

import java.io.Serializable;

public class Resultado implements Serializable {
    private Peticion peticion;
    private String valores;
    private boolean esCritico;
    private boolean esReservado;

    public Resultado(Peticion peticion, String valores, boolean esCritico, boolean esReservado) {
        this.peticion = peticion;
        this.valores = valores;
        this.esCritico = esCritico;
        this.esReservado = esReservado;
    }

    // Getters y Setters
    public Peticion getPeticion() { return peticion; }
    public void setPeticion(Peticion peticion) { this.peticion = peticion; }
    public String getValores() { return valores; }
    public void setValores(String valores) { this.valores = valores; }
    public boolean isEsCritico() { return esCritico; }
    public void setEsCritico(boolean esCritico) { this.esCritico = esCritico; }
    public boolean isEsReservado() { return esReservado; }
    public void setEsReservado(boolean esReservado) { this.esReservado = esReservado; }
}
