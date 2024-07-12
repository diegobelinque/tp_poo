package modelo;

public class ResultadoDTO {
    private PeticionDTO peticion;
    private String valores;
    private boolean esCritico;
    private boolean esReservado;
    private boolean finalizado; // Añadido

    public ResultadoDTO(PeticionDTO peticion, String valores, boolean esCritico, boolean esReservado, boolean finalizado) { // Ajustado
        this.peticion = peticion;
        this.valores = valores;
        this.esCritico = esCritico;
        this.esReservado = esReservado;
        this.finalizado = finalizado; // Añadido
    }

    // Getters y Setters
    public PeticionDTO getPeticion() { return peticion; }
    public void setPeticion(PeticionDTO peticion) { this.peticion = peticion; }
    public String getValores() { return valores; }
    public void setValores(String valores) { this.valores = valores; }
    public boolean isEsCritico() { return esCritico; }
    public void setEsCritico(boolean esCritico) { this.esCritico = esCritico; }
    public boolean isEsReservado() { return esReservado; }
    public void setEsReservado(boolean esReservado) { this.esReservado = esReservado; }
    public boolean isFinalizado() { return finalizado; } // Añadido
    public void setFinalizado(boolean finalizado) { this.finalizado = finalizado; } // Añadido

    public Resultado toEntity() {
        return new Resultado(peticion.toEntity(), valores, esCritico, esReservado, finalizado); // Ajustado
    }
}