package vistas;

import controladores.PacienteController;
import modelo.Datos;
import modelo.Paciente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PacienteForm extends JFrame {
    private JTextField dniField;
    private JTextField nombreField;
    private JTextField domicilioField;
    private JTextField mailField;
    private JTextField sexoField;
    private JTextField edadField;
    private JButton saveButton;
    private Paciente paciente;
    private PacienteController controller;

    public PacienteForm(PacienteController controller, Paciente paciente) {
        this.controller = controller;
        this.paciente = paciente;
        setTitle(paciente == null ? "Alta Paciente" : "Modificar Paciente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("DNI:"));
        dniField = new JTextField(paciente != null ? paciente.getDni() : "");
        add(dniField);

        add(new JLabel("Nombre:"));
        nombreField = new JTextField(paciente != null ? paciente.getNombre() : "");
        add(nombreField);

        add(new JLabel("Domicilio:"));
        domicilioField = new JTextField(paciente != null ? paciente.getDomicilio() : "");
        add(domicilioField);

        add(new JLabel("Mail:"));
        mailField = new JTextField(paciente != null ? paciente.getMail() : "");
        add(mailField);

        add(new JLabel("Sexo:"));
        sexoField = new JTextField(paciente != null ? paciente.getSexo() : "");
        add(sexoField);

        add(new JLabel("Edad:"));
        edadField = new JTextField(paciente != null ? String.valueOf(paciente.getEdad()) : "");
        add(edadField);

        saveButton = new JButton("Guardar");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPaciente();
            }
        });
    }

    private void guardarPaciente() {
        if (paciente == null) {
            paciente = new Paciente(
                    dniField.getText(),
                    nombreField.getText(),
                    domicilioField.getText(),
                    mailField.getText(),
                    sexoField.getText(),
                    Integer.parseInt(edadField.getText())
            );
            controller.agregarPaciente(paciente);
        } else {
            paciente.setDni(dniField.getText());
            paciente.setNombre(nombreField.getText());
            paciente.setDomicilio(domicilioField.getText());
            paciente.setMail(mailField.getText());
            paciente.setSexo(sexoField.getText());
            paciente.setEdad(Integer.parseInt(edadField.getText()));
            controller.modificarPaciente(paciente);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarPacientes())); // Guardar los datos
        dispose();
    }
}