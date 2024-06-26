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
    }

    public void eliminarPeticion(Paciente paciente, Date fechaCarga) {
        peticiones.removeIf(peticion -> peticion.getPaciente().equals(paciente) && peticion.getFechaCarga().equals(fechaCarga));
    }

    public List<Peticion> listarPeticiones() {
        return peticiones;
    }
}