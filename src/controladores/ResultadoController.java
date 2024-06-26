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
        resultados.add(resultado);
    }

    public void modificarResultado(Resultado resultado) {
        for (int i = 0; i < resultados.size(); i++) {
            if (resultados.get(i).getPeticion().equals(resultado.getPeticion())) {
                resultados.set(i, resultado);
                return;
            }
        }
    }

    public void eliminarResultado(Peticion peticion) {
        resultados.removeIf(resultado -> resultado.getPeticion().equals(peticion));
    }

    public List<Resultado> listarResultados() {
        return resultados;
    }
}
