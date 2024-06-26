package vistas;

import controladores.UsuarioController;
import modelo.Datos;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class UsuarioForm extends JFrame {
    private JTextField nombreUsuarioField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField nombreField;
    private JTextField domicilioField;
    private JTextField dniField;
    private JTextField fechaNacimientoField;
    private JTextField rolField;
    private JButton saveButton;
    private Usuario usuario;
    private UsuarioController controller;

    public UsuarioForm(UsuarioController controller, Usuario usuario) {
        this.controller = controller;
        this.usuario = usuario;
        setTitle(usuario == null ? "Alta Usuario" : "Modificar Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        add(new JLabel("Nombre de Usuario:"));
        nombreUsuarioField = new JTextField(usuario != null ? usuario.getNombreUsuario() : "");
        add(nombreUsuarioField);

        add(new JLabel("Email:"));
        emailField = new JTextField(usuario != null ? usuario.getEmail() : "");
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField(usuario != null ? usuario.getPassword() : "");
        add(passwordField);

        add(new JLabel("Nombre:"));
        nombreField = new JTextField(usuario != null ? usuario.getNombre() : "");
        add(nombreField);

        add(new JLabel("Domicilio:"));
        domicilioField = new JTextField(usuario != null ? usuario.getDomicilio() : "");
        add(domicilioField);

        add(new JLabel("DNI:"));
        dniField = new JTextField(usuario != null ? usuario.getDni() : "");
        add(dniField);

        add(new JLabel("Fecha de Nacimiento:"));
        fechaNacimientoField = new JTextField(usuario != null ? usuario.getFechaNacimiento().toString() : "");
        add(fechaNacimientoField);

        add(new JLabel("Rol:"));
        rolField = new JTextField(usuario != null ? usuario.getRol() : "");
        add(rolField);

        saveButton = new JButton("Guardar");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }
        });
    }

    private void guardarUsuario() {
        if (usuario == null) {
            usuario = new Usuario(
                    nombreUsuarioField.getText(),
                    emailField.getText(),
                    new String(passwordField.getPassword()),
                    nombreField.getText(),
                    domicilioField.getText(),
                    dniField.getText(),
                    new Date(fechaNacimientoField.getText()),
                    rolField.getText()
            );
            controller.agregarUsuario(usuario);
        } else {
            usuario.setNombreUsuario(nombreUsuarioField.getText());
            usuario.setEmail(emailField.getText());
            usuario.setPassword(new String(passwordField.getPassword()));
            usuario.setNombre(nombreField.getText());
            usuario.setDomicilio(domicilioField.getText());
            usuario.setDni(dniField.getText());
            usuario.setFechaNacimiento(new Date(fechaNacimientoField.getText()));
            usuario.setRol(rolField.getText());
            controller.modificarUsuario(usuario);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarUsuarios())); // Guardar los datos
        dispose();
    }
}
