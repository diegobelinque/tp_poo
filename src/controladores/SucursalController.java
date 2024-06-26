package controladores;

import modelo.Sucursal;

import java.util.ArrayList;
import java.util.List;

public class SucursalController {
    private List<Sucursal> sucursales;

    public SucursalController() {
        sucursales = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal sucursal) {
        for (Sucursal s : sucursales) {
            if (s.getNumero() == sucursal.getNumero()) {
                throw new IllegalArgumentException("La sucursal con el mismo número ya existe.");
            }
        }
        sucursales.add(sucursal);
    }

    public void modificarSucursal(Sucursal sucursal) {
        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i).getNumero() == sucursal.getNumero()) {
                sucursales.set(i, sucursal);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró la sucursal con el número especificado.");
    }

    public void eliminarSucursal(int numero) {
        boolean eliminado = sucursales.removeIf(sucursal -> sucursal.getNumero() == numero);
        if (!eliminado) {
            throw new IllegalArgumentException("No se encontró la sucursal con el número especificado.");
        }
    }

    public List<Sucursal> listarSucursales() {
        return new ArrayList<>(sucursales);
    }
}