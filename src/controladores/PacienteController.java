package controladores;

import modelo.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private List<Paciente> pacientes;

    public PacienteController() {
        pacientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void modificarPaciente(Paciente paciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getDni().equals(paciente.getDni())) {
                pacientes.set(i, paciente);
                return;
            }
        }
    }

    public void eliminarPaciente(String dni) {
        pacientes.removeIf(paciente -> paciente.getDni().equals(dni));
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }
}