package vistas;

import controladores.PracticaController;
import modelo.Datos;
import modelo.Practica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PracticaForm extends JFrame {
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField grupoField;
    private JTextField valoresCriticosField;
    private JTextField valoresReservadosField;
    private JTextField horasField;
    private JButton saveButton;
    private Practica practica;
    private PracticaController controller;

    public PracticaForm(PracticaController controller, Practica practica) {
        this.controller = controller;
        this.practica = practica;
        setTitle(practica == null ? "Alta Práctica" : "Modificar Práctica");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        add(new JLabel("Código:"));
        codigoField = new JTextField(practica != null ? practica.getCodigo() : "");
        add(codigoField);

        add(new JLabel("Nombre:"));
        nombreField = new JTextField(practica != null ? practica.getNombre() : "");
        add(nombreField);

        add(new JLabel("Grupo:"));
        grupoField = new JTextField(practica != null ? practica.getGrupo() : "");
        add(grupoField);

        add(new JLabel("Valores Críticos:"));
        valoresCriticosField = new JTextField(practica != null ? practica.getValoresCriticos() : "");
        add(valoresCriticosField);

        add(new JLabel("Valores Reservados:"));
        valoresReservadosField = new JTextField(practica != null ? practica.getValoresReservados() : "");
        add(valoresReservadosField);

        add(new JLabel("Horas para Resultado:"));
        horasField = new JTextField(practica != null ? String.valueOf(practica.getHorasParaResultado()) : "");
        add(horasField);

        saveButton = new JButton("Guardar");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarPractica();
            }
        });
    }

    private void guardarPractica() {
        if (practica == null) {
            practica = new Practica(
                    codigoField.getText(),
                    nombreField.getText(),
                    grupoField.getText(),
                    valoresCriticosField.getText(),
                    valoresReservadosField.getText(),
                    Integer.parseInt(horasField.getText())
            );
            controller.agregarPractica(practica);
        } else {
            practica.setCodigo(codigoField.getText());
            practica.setNombre(nombreField.getText());
            practica.setGrupo(grupoField.getText());
            practica.setValoresCriticos(valoresCriticosField.getText());
            practica.setValoresReservados(valoresReservadosField.getText());
            practica.setHorasParaResultado(Integer.parseInt(horasField.getText()));
            controller.modificarPractica(practica);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarPracticas())); // Guardar los datos
        dispose();
    }
}
