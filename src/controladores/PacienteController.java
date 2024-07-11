package controladores;

import modelo.Paciente;
import modelo.PacienteDTO;

import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private static List<Paciente> pacientes;

    private static PacienteController CONTROLLER = null;

    public PacienteController() {
        pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        for (Paciente p : pacientes) {
            if (p.getDni().equals(paciente.getDni())) {
                throw new IllegalArgumentException("El paciente con DNI " + paciente.getDni() + " ya existe.");
            }
        }
        pacientes.add(paciente);
    }

    public void modificarPaciente(Paciente paciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getDni().equals(paciente.getDni())) {
                pacientes.set(i, paciente);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró el paciente con DNI " + paciente.getDni());
    }

    public void eliminarPaciente(String dni) {
        boolean eliminado = pacientes.removeIf(paciente -> paciente.getDni().equals(dni));
        if (!eliminado) {
            throw new IllegalArgumentException("No se encontró el paciente con DNI " + dni);
        }
    }

    public PacienteDTO buscarPaciente(String dni) {
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                return paciente.getDTO(paciente);
            }
        }
        return null; // Devuelve null si no se encuentra el paciente
    }


    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

    public static PacienteController getInstance() throws Exception{
        if (CONTROLLER == null){
            CONTROLLER = new PacienteController();
            pacientes = new ArrayList<>();
        }
        return CONTROLLER;
    }
}