package controladores;

import modelo.Paciente;
import modelo.Peticion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionController {
    private static List<Peticion> peticiones;
    private static PeticionController CONTROLLER = null;

    public PeticionController() {
        peticiones = new ArrayList<>();
    }

    public void agregarPeticion(Peticion peticion) {
        for (Peticion p : peticiones) {
            if (p.getPaciente().getDni().equals(peticion.getPaciente().getDni()) &&
                    p.getFechaCarga().equals(peticion.getFechaCarga())) {
                throw new IllegalArgumentException("La petición para el paciente con DNI " + peticion.getPaciente().getDni() + " en la fecha " + peticion.getFechaCarga() + " ya existe.");
            }
        }
        peticiones.add(peticion);
    }

    public void modificarPeticion(Peticion peticion) {
        for (int i = 0; i < peticiones.size(); i++) {
            if (peticiones.get(i).getPaciente().getDni().equals(peticion.getPaciente().getDni()) &&
                    peticiones.get(i).getFechaCarga().equals(peticion.getFechaCarga())) {
                peticiones.set(i, peticion);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró la petición para el paciente con DNI " + peticion.getPaciente().getDni() + " en la fecha " + peticion.getFechaCarga());
    }

    public void eliminarPeticion(String dniPaciente, Date fechaCarga) {
        boolean eliminado = peticiones.removeIf(peticion ->
                peticion.getPaciente().getDni().equals(dniPaciente) && peticion.getFechaCarga().equals(fechaCarga)
        );
        if (!eliminado) {
            throw new IllegalArgumentException("No se encontró la petición para el paciente con DNI " + dniPaciente + " en la fecha " + fechaCarga);
        }
    }

    public Peticion buscarPeticion(String dniPaciente, Date fechaCarga) {
        for (Peticion peticion : peticiones) {
            if (peticion.getPaciente().getDni().equals(dniPaciente) && peticion.getFechaCarga().equals(fechaCarga)) {
                return peticion;
            }
        }
        return null; // Devuelve null si no se encuentra la petición
    }

    public List<Peticion> listarPeticiones() {
        return new ArrayList<>(peticiones);
    }

    public List<Peticion> listarPeticionesPorPaciente(String dniPaciente) {
        List<Peticion> peticionesPaciente = new ArrayList<>();
        for (Peticion peticion : peticiones) {
            if (peticion.getPaciente().getDni().equals(dniPaciente)) {
                peticionesPaciente.add(peticion);
            }
        }
        return peticionesPaciente;
    }

    public static PeticionController getInstance() {
        if (CONTROLLER == null){
            CONTROLLER = new PeticionController();
            peticiones = new ArrayList<>();
        }
        return CONTROLLER;
    }
}