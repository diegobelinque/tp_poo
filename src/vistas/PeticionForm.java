package vistas;

import controladores.PacienteController;
import controladores.PeticionController;
import controladores.PracticaController;
import modelo.Datos;
import modelo.Paciente;
import modelo.Peticion;
import modelo.Practica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionForm extends JFrame {
    private JComboBox<Paciente> pacienteComboBox;
    private JTextField obraSocialField;
    private JTextField fechaCargaField;
    private JComboBox<Practica> practicasComboBox;
    private JTextField fechaEntregaField;
    private JButton saveButton;
    private Peticion peticion;
    private PeticionController controller;
    private PacienteController pacienteController;
    private PracticaController practicaController;

    public PeticionForm(PeticionController controller, PacienteController pacienteController, PracticaController practicaController, Peticion peticion) {
        this.controller = controller;
        this.pacienteController = pacienteController;
        this.practicaController = practicaController;
        this.peticion = peticion;
        setTitle(peticion == null ? "Alta Petición" : "Modificar Petición");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("Paciente:"));
        pacienteComboBox = new JComboBox<>();
        for (Paciente paciente : pacienteController.listarPacientes()) {
            pacienteComboBox.addItem(paciente);
        }
        if (peticion != null) {
            pacienteComboBox.setSelectedItem(peticion.getPaciente());
        }
        add(pacienteComboBox);

        add(new JLabel("Obra Social:"));
        obraSocialField = new JTextField(peticion != null ? peticion.getObraSocial() : "");
        add(obraSocialField);

        add(new JLabel("Fecha de Carga:"));
        fechaCargaField = new JTextField(peticion != null ? peticion.getFechaCarga().toString() : "");
        add(fechaCargaField);

        add(new JLabel("Prácticas:"));
        practicasComboBox = new JComboBox<>();
        for (Practica practica : practicaController.listarPracticas()) {
            practicasComboBox.addItem(practica);
        }
        if (peticion != null) {
            practicasComboBox.setSelectedItem(peticion.getPracticasAsociadas().get(0)); // Simplificado
        }
        add(practicasComboBox);

        add(new JLabel("Fecha de Entrega:"));
        fechaEntregaField = new JTextField(peticion != null ? peticion.getFechaEntrega().toString() : "");
        add(fechaEntregaField);

        saveButton = new JButton("Guardar");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPeticion();
            }
        });
    }

    private void guardarPeticion() {
        Paciente paciente = (Paciente) pacienteComboBox.getSelectedItem();
        Practica practica = (Practica) practicasComboBox.getSelectedItem();
        List<Practica> practicasAsociadas = List.of(practica); // Simplificado

        if (peticion == null) {
            peticion = new Peticion(
                    paciente,
                    obraSocialField.getText(),
                    new Date(fechaCargaField.getText()),
                    practicasAsociadas,
                    new Date(fechaEntregaField.getText())
            );
            controller.agregarPeticion(peticion);
        } else {
            peticion.setPaciente(paciente);
            peticion.setObraSocial(obraSocialField.getText());
            peticion.setFechaCarga(new Date(fechaCargaField.getText()));
            peticion.setPracticasAsociadas(practicasAsociadas);
            peticion.setFechaEntrega(new Date(fechaEntregaField.getText()));
            controller.modificarPeticion(peticion);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarPeticiones())); // Guardar los datos
        dispose();
    }
}