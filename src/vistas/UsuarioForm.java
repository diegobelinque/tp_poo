package vistas;

import controladores.UsuarioController;
import modelo.Datos;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Add padding
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        addLabelAndField(gbc, "Nombre de Usuario:", 0, nombreUsuarioField = new JTextField(usuario != null ? usuario.getNombreUsuario() : ""));
        addLabelAndField(gbc, "Email:", 1, emailField = new JTextField(usuario != null ? usuario.getEmail() : ""));
        addLabelAndField(gbc, "Password:", 2, passwordField = new JPasswordField(usuario != null ? usuario.getPassword() : ""));
        addLabelAndField(gbc, "Nombre:", 3, nombreField = new JTextField(usuario != null ? usuario.getNombre() : ""));
        addLabelAndField(gbc, "Domicilio:", 4, domicilioField = new JTextField(usuario != null ? usuario.getDomicilio() : ""));
        addLabelAndField(gbc, "DNI:", 5, dniField = new JTextField(usuario != null ? usuario.getDni() : ""));
        addLabelAndField(gbc, "Fecha de Nacimiento (dd/MM/yyyy):", 6, fechaNacimientoField = new JTextField(usuario != null ? new SimpleDateFormat("dd/MM/yyyy").format(usuario.getFechaNacimiento()) : ""));
        addLabelAndField(gbc, "Rol:", 7, rolField = new JTextField(usuario != null ? usuario.getRol() : ""));

        saveButton = new JButton("Guardar");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        add(saveButton, gbc);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarUsuario();
            }
        });
    }

    private void addLabelAndField(GridBagConstraints gbc, String labelText, int yPos, JTextField textField) {
        gbc.gridx = 0;
        gbc.gridy = yPos;
        add(new JLabel(labelText), gbc);
        gbc.gridx = 1;
        gbc.gridy = yPos;
        gbc.gridwidth = 1;
        textField.setColumns(20);
        add(textField, gbc);
    }

    private void guardarUsuario() {
        try {
            Date fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimientoField.getText());

            if (usuario == null) {
                usuario = new Usuario(
                        nombreUsuarioField.getText(),
                        emailField.getText(),
                        new String(passwordField.getPassword()),
                        nombreField.getText(),
                        domicilioField.getText(),
                        dniField.getText(),
                        fechaNacimiento,
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
                usuario.setFechaNacimiento(fechaNacimiento);
                usuario.setRol(rolField.getText());
                controller.modificarUsuario(usuario);
            }

            Datos.guardarDatos(new ArrayList<>(controller.listarUsuarios())); // Guardar los datos
            dispose();

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }}