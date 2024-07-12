package modelo;

import java.io.Serializable;

public class Resultado implements Serializable {
    private Peticion peticion;
    private String valores;
    private boolean esCritico;
    private boolean esReservado;
    private boolean finalizado; // Añadido

    public Resultado(Peticion peticion, String valores, boolean esCritico, boolean esReservado, boolean finalizado) {
        this.peticion = peticion;
        this.valores = valores;
        this.esCritico = esCritico;
        this.esReservado = esReservado;
        this.finalizado = finalizado; // Añadido
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
    public boolean isFinalizado() { return finalizado; } // Añadido
    public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; } // Añadido

    public ResultadoDTO toDTO() {
        return new ResultadoDTO(
                this.peticion.getDTO(this.peticion),
                this.valores,
                this.esCritico,
                this.esReservado,
                this.finalizado
        );
    }
}