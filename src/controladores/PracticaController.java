package controladores;

import modelo.Practica;

import java.util.ArrayList;
import java.util.List;

public class PracticaController {
    private List<Practica> practicas;

    public PracticaController() {
        practicas = new ArrayList<>();
    }

    public void agregarPractica(Practica practica) {
        practicas.add(practica);
    }

    public void modificarPractica(Practica practica) {
        for (int i = 0; i < practicas.size(); i++) {
            if (practicas.get(i).getCodigo().equals(practica.getCodigo())) {
                practicas.set(i, practica);
                return;
            }
        }
    }

    public void eliminarPractica(String codigo) {
        practicas.removeIf(practica -> practica.getCodigo().equals(codigo));
    }

    public List<Practica> listarPracticas() {
        return practicas;
    }
}
