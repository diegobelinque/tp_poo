package vistas;

import controladores.PeticionController;
import controladores.ResultadoController;
import modelo.Datos;
import modelo.Peticion;
import modelo.Resultado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ResultadoForm extends JFrame {
    private JComboBox<Peticion> peticionComboBox;
    private JTextField valoresField;
    private JCheckBox esCriticoCheckBox;
    private JCheckBox esReservadoCheckBox;
    private JButton saveButton;
    private Resultado resultado;
    private ResultadoController controller;
    private PeticionController peticionController;

    public ResultadoForm(ResultadoController controller, PeticionController peticionController, Resultado resultado) {
        this.controller = controller;
        this.peticionController = peticionController;
        this.resultado = resultado;
        setTitle(resultado == null ? "Alta Resultado" : "Modificar Resultado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Petición:"));
        peticionComboBox = new JComboBox<>();
        for (Peticion peticion : peticionController.listarPeticiones()) {
            peticionComboBox.addItem(peticion);
        }
        if (resultado != null) {
            peticionComboBox.setSelectedItem(resultado.getPeticion());
        }
        add(peticionComboBox);

        add(new JLabel("Valores:"));
        valoresField = new JTextField(resultado != null ? resultado.getValores() : "");
        add(valoresField);

        add(new JLabel("Es Crítico:"));
        esCriticoCheckBox = new JCheckBox();
        esCriticoCheckBox.setSelected(resultado != null && resultado.isEsCritico());
        add(esCriticoCheckBox);

        add(new JLabel("Es Reservado:"));
        esReservadoCheckBox = new JCheckBox();
        esReservadoCheckBox.setSelected(resultado != null && resultado.isEsReservado());
        add(esReservadoCheckBox);

        saveButton = new JButton("Guardar");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarResultado();
            }
        });
    }

    private void guardarResultado() {
        Peticion peticion = (Peticion) peticionComboBox.getSelectedItem();

        if (resultado == null) {
            resultado = new Resultado(
                    peticion,
                    valoresField.getText(),
                    esCriticoCheckBox.isSelected(),
                    esReservadoCheckBox.isSelected()
            );
            controller.agregarResultado(resultado);
        } else {
            resultado.setPeticion(peticion);
            resultado.setValores(valoresField.getText());
            resultado.setEsCritico(esCriticoCheckBox.isSelected());
            resultado.setEsReservado(esReservadoCheckBox.isSelected());
            controller.modificarResultado(resultado);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarResultados())); // Guardar los datos
        dispose();
    }
}
