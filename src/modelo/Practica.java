package modelo;

import java.io.Serializable;

public class Practica implements Serializable {
    private String codigo;
    private String nombre;
    private String grupo;
    private String valoresCriticos;
    private String valoresReservados;
    private int horasParaResultado;

    public Practica(String codigo, String nombre, String grupo, String valoresCriticos, String valoresReservados, int horasParaResultado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.grupo = grupo;
        this.valoresCriticos = valoresCriticos;
        this.valoresReservados = valoresReservados;
        this.horasParaResultado = horasParaResultado;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
    public String getValoresCriticos() { return valoresCriticos; }
    public void setValoresCriticos(String valoresCriticos) { this.valoresCriticos = valoresCriticos; }
    public String getValoresReservados() { return valoresReservados; }
    public void setValoresReservados(String valoresReservados) { this.valoresReservados = valoresReservados; }
    public int getHorasParaResultado() { return horasParaResultado; }
    public void setHorasParaResultado(int horasParaResultado) { this.horasParaResultado = horasParaResultado; }
}