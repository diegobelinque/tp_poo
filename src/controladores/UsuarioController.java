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
        usuarios.add(usuario);
    }

    public void modificarUsuario(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equals(usuario.getNombreUsuario())) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    public void eliminarUsuario(String nombreUsuario) {
        usuarios.removeIf(usuario -> usuario.getNombreUsuario().equals(nombreUsuario));
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}
