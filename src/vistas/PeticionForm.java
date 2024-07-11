package vistas;

import controladores.PacienteController;
import controladores.PeticionController;
import controladores.PracticaController;
import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
        fechaCargaField = new JTextField(peticion != null ? dateFormat.format(peticion.getFechaCarga()) : "");
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
        fechaEntregaField = new JTextField(peticion != null ? dateFormat.format(peticion.getFechaEntrega()) : "");
        add(fechaEntregaField);

        saveButton = new JButton("Guardar");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    guardarPeticion();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(PeticionForm.this, "Formato de fecha incorrecto. Use 'yyyy-MM-dd'.");
                }
            }
        });
    }

    private void guardarPeticion() throws ParseException {
        Paciente paciente = (Paciente) pacienteComboBox.getSelectedItem();
        Practica practica = (Practica) practicasComboBox.getSelectedItem();
        List<Practica> practicasAsociadas = new ArrayList<>();
        practicasAsociadas.add(practica); // Simplificado

        Date fechaCarga = dateFormat.parse(fechaCargaField.getText());
        Date fechaEntrega = dateFormat.parse(fechaEntregaField.getText());

        if (peticion == null) {
            peticion = new Peticion(
                    paciente,
                    obraSocialField.getText(),
                    fechaCarga,
                    practicasAsociadas,
                    fechaEntrega
            );
            controller.agregarPeticion(peticion);
        } else {
            peticion.setPaciente(paciente);
            peticion.setObraSocial(obraSocialField.getText());
            peticion.setFechaCarga(fechaCarga);
            peticion.setPracticasAsociadas(practicasAsociadas);
            peticion.setFechaEntrega(fechaEntrega);
            controller.modificarPeticion(peticion);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarPeticiones())); // Guardar los datos
        dispose();
    }
}