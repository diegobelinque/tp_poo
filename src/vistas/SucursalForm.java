package vistas;

import controladores.SucursalController;
import modelo.Datos;
import modelo.Sucursal;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class SucursalForm extends JFrame {
    private JTextField numeroField;
    private JTextField direccionField;
    private JTextField responsableField;
    private JButton saveButton;
    private Sucursal sucursal;
    private SucursalController controller;

    public SucursalForm(SucursalController controller, Sucursal sucursal) {
        this.controller = controller;
        this.sucursal = sucursal;
        setTitle(sucursal == null ? "Alta Sucursal" : "Modificar Sucursal");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Número:"));
        numeroField = new JTextField(sucursal != null ? String.valueOf(sucursal.getNumero()) : "");
        add(numeroField);

        add(new JLabel("Dirección:"));
        direccionField = new JTextField(sucursal != null ? sucursal.getDireccion() : "");
        add(direccionField);

        add(new JLabel("Responsable Técnico:"));
        responsableField = new JTextField(sucursal != null ? sucursal.getResponsableTecnico().getNombreUsuario() : "");
        add(responsableField);

        saveButton = new JButton("Guardar");
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarSucursal();
            }
        });
    }

    private void guardarSucursal() {
        Usuario responsable = new Usuario(responsableField.getText(), "", "", "", "", "", new Date(), ""); // Simplificado
        if (sucursal == null) {
            sucursal = new Sucursal(
                    Integer.parseInt(numeroField.getText()),
                    direccionField.getText(),
                    responsable
            );
            controller.agregarSucursal(sucursal);
        } else {
            sucursal.setNumero(Integer.parseInt(numeroField.getText()));
            sucursal.setDireccion(direccionField.getText());
            sucursal.setResponsableTecnico(responsable);
            controller.modificarSucursal(sucursal);
        }

        Datos.guardarDatos(new ArrayList<>(controller.listarSucursales())); // Guardar los datos
        dispose();
    }
}
