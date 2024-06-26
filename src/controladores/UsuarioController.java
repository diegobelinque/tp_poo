package controladores;

import modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    private List<Usuario> usuarios;

    public UsuarioController() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(usuario.getNombreUsuario())) {
                throw new IllegalArgumentException("El usuario con el mismo nombre ya existe.");
            }
        }
        usuarios.add(usuario);
    }

    public void modificarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(usuario.getNombreUsuario())) {
                usuarios.set(i, usuario);
                return;
            }
        }
        throw new IllegalArgumentException("No se encontró el usuario con el nombre especificado.");
    }

    public void eliminarUsuario(String nombreUsuario) {
        boolean eliminado = usuarios.removeIf(usuario -> usuario.getNombreUsuario().equals(nombreUsuario));
        if (!eliminado) {
            throw new IllegalArgumentException("No se encontró el usuario con el nombre especificado.");
        }
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}