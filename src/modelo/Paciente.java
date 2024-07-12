package modelo;

import controladores.PeticionController;
import controladores.ResultadoController;

import java.io.Serializable;
import java.util.List;

public class Paciente implements Serializable {
    private String dni;
    private String nombre;
    private String domicilio;
    private String mail;
    private String sexo;
    private int edad;

    public Paciente(String dni, String nombre, String domicilio, String mail, String sexo, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.mail = mail;
        this.sexo = sexo;
        this.edad = edad;
    }

    // Getters y Setters
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public PacienteDTO getDTO(Paciente paciente){
        return new PacienteDTO(paciente.getDni(), paciente.getNombre(), paciente.getDomicilio(), paciente.getMail(), paciente.getSexo(), paciente.getEdad());
    }

    public boolean puedeSerEliminado(PeticionController peticionController, ResultadoController resultadoController) {
        List<Peticion> peticionesPaciente = peticionController.listarPeticionesPorPaciente(this.dni);
        for (Peticion peticion : peticionesPaciente) {
            if (resultadoController.listarResultadosPorPeticion(peticion).stream().anyMatch(Resultado::isFinalizado)) {
                return false;
            }
        }
        return true;
    }
}