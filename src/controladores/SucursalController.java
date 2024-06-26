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
        sucursales.add(sucursal);
    }

    public void modificarSucursal(Sucursal sucursal) {
        for (int i = 0; i < sucursales.size(); i++) {
            if (sucursales.get(i).getNumero() == sucursal.getNumero()) {
                sucursales.set(i, sucursal);
                return;
            }
        }
    }

    public void eliminarSucursal(int numero) {
        sucursales.removeIf(sucursal -> sucursal.getNumero() == numero);
    }

    public List<Sucursal> listarSucursales() {
        return sucursales;
    }
}
