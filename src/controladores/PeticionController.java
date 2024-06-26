package controladores;

import modelo.Paciente;
import modelo.Peticion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionController {
    private List<Peticion> peticiones;

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

    public void eliminarPeticion(Paciente paciente, Date fechaCarga) {
        boolean eliminado = peticiones.removeIf(peticion -> peticion.getPaciente().equals(paciente) && peticion.getFechaCarga().equals(fechaCarga));
        if (!eliminado) {
            throw new IllegalArgumentException("No se encontró la petición para el paciente con DNI " + paciente.getDni() + " en la fecha " + fechaCarga);
        }
    }

    public List<Peticion> listarPeticiones() {
        return new ArrayList<>(peticiones);
    }
}