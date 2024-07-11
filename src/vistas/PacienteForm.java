package vistas;

import controladores.PacienteController;
import modelo.Datos;
import modelo.Paciente;
import modelo.PacienteDTO;

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
    private PacienteController controller;

    public PacienteForm(PacienteController controller, PacienteDTO pacienteDTO) {
        this.controller = controller;
        setTitle(pacienteDTO == null ? "Alta Paciente" : "Modificar Paciente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("DNI:"));
        dniField = new JTextField(pacienteDTO != null ? pacienteDTO.getDni() : "");
        add(dniField);

        add(new JLabel("Nombre:"));
        nombreField = new JTextField(pacienteDTO != null ? pacienteDTO.getNombre() : "");
        add(nombreField);

        add(new JLabel("Domicilio:"));
        domicilioField = new JTextField(pacienteDTO != null ? pacienteDTO.getDomicilio() : "");
        add(domicilioField);

        add(new JLabel("Mail:"));
        mailField = new JTextField(pacienteDTO != null ? pacienteDTO.getMail() : "");
        add(mailField);

        add(new JLabel("Sexo:"));
        sexoField = new JTextField(pacienteDTO != null ? pacienteDTO.getSexo() : "");
        add(sexoField);

        add(new JLabel("Edad:"));
        edadField = new JTextField(pacienteDTO != null ? String.valueOf(pacienteDTO.getEdad()) : "");
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
        Paciente paciente = new Paciente(
                dniField.getText(),
                nombreField.getText(),
                domicilioField.getText(),
                mailField.getText(),
                sexoField.getText(),
                Integer.parseInt(edadField.getText())
        );

        if (controller.buscarPaciente(paciente.getDni()) == null) {
            controller.agregarPaciente(paciente);
        } else {
            controller.modificarPaciente(paciente);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarPacientes())); // Guardar los datos
        dispose();
    }
}