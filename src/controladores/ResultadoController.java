package controladores;

import modelo.Peticion;
import modelo.Resultado;

import java.util.ArrayList;
import java.util.List;

public class ResultadoController {
    private List<Resultado> resultados;

    public ResultadoController() {
        resultados = new ArrayList<>();
    }

    public void agregarResultado(Resultado resultado) {
        for (Resultado r : resultados) {
            if (r.getPeticion().equals(resultado.getPeticion())) {
                throw new IllegalArgumentException("El resultado para la petición ya existe.");
            }
        }
        resultados.add(resultado);
    }

    public void modificarResultado(Resultado resultado) {
        for (int i = 0; i < resultados.size(); i++) {
            if (resultados.get(i).getPeticion().equals(resultado.getPeticion())) {
                resultados.set(i, resultado);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró el resultado para la petición especificada.");
    }

    public void eliminarResultado(Peticion peticion) {
        boolean eliminado = resultados.removeIf(resultado -> resultado.getPeticion().equals(peticion));
        if (!eliminado) {
            throw new IllegalArgumentException("No se encontró el resultado para la petición especificada.");
        }
    }

    public List<Resultado> listarResultados() {
        return new ArrayList<>(resultados);
    }
}