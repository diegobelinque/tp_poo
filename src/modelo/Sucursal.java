package modelo;

import java.io.Serializable;

public class Sucursal implements Serializable {
    private int numero;
    private String direccion;
    private Usuario responsableTecnico;

    public Sucursal(int numero, String direccion, Usuario responsableTecnico) {
        this.numero = numero;
        this.direccion = direccion;
        this.responsableTecnico = responsableTecnico;
    }

    // Getters y Setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public Usuario getResponsableTecnico() { return responsableTecnico; }
    public void setResponsableTecnico(Usuario responsableTecnico) { this.responsableTecnico = responsableTecnico; }
}