package modelo;

public class ResultadoDTO {
    private PeticionDTO peticion;
    private String valores;
    private boolean esCritico;
    private boolean esReservado;

    public ResultadoDTO(PeticionDTO peticion, String valores, boolean esCritico, boolean esReservado) {
        this.peticion = peticion;
        this.valores = valores;
        this.esCritico = esCritico;
        this.esReservado = esReservado;
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

    public Resultado toEntity() {
        return new Resultado(peticion.toEntity(), valores, esCritico, esReservado);
    }
}