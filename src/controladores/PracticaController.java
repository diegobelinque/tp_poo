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
        for (Practica p : practicas) {
            if (p.getCodigo().equals(practica.getCodigo())) {
                throw new IllegalArgumentException("La práctica con código " + practica.getCodigo() + " ya existe.");
            }
        }
        practicas.add(practica);
    }

    public void modificarPractica(Practica practica) {
        for (int i = 0; i < practicas.size(); i++) {
            if (practicas.get(i).getCodigo().equals(practica.getCodigo())) {
                practicas.set(i, practica);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró la práctica con código " + practica.getCodigo());
    }

    public void eliminarPractica(String codigo) {
        boolean eliminado = practicas.removeIf(practica -> practica.getCodigo().equals(codigo));
        if (!eliminado) {
            throw new IllegalArgumentException("No se encontró la práctica con código " + codigo);
        }
    }

    public Practica buscarPractica(String codigo) {
        for (Practica practica : practicas) {
            if (practica.getCodigo().equals(codigo)) {
                return practica;
            }
        }
        return null; // Devuelve null si no se encuentra la práctica
    }

    public List<Practica> listarPracticas() {
        return new ArrayList<>(practicas);
    }
}