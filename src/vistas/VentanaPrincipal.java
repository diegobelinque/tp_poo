package vistas;

import controladores.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private PacienteController pacienteController;
    private SucursalController sucursalController;
    private PracticaController practicaController;
    private PeticionController peticionController;
    private UsuarioController usuarioController;
    private ResultadoController resultadoController;

    public VentanaPrincipal() {
        pacienteController = new PacienteController();
        sucursalController = new SucursalController();
        practicaController = new PracticaController();
        peticionController = new PeticionController();
        usuarioController = new UsuarioController();
        resultadoController = new ResultadoController();

        setTitle("Sistema de Gestión de Laboratorio");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuPacientes = new JMenu("Pacientes");
        JMenuItem itemAltaPaciente = new JMenuItem("Alta");
        JMenuItem itemBajaPaciente = new JMenuItem("Baja");
        JMenuItem itemModificacionPaciente = new JMenuItem("Modificación");
        menuPacientes.add(itemAltaPaciente);
        menuPacientes.add(itemBajaPaciente);
        menuPacientes.add(itemModificacionPaciente);

        JMenu menuSucursales = new JMenu("Sucursales");
        JMenuItem itemAltaSucursal = new JMenuItem("Alta");
        JMenuItem itemBajaSucursal = new JMenuItem("Baja");
        JMenuItem itemModificacionSucursal = new JMenuItem("Modificación");
        menuSucursales.add(itemAltaSucursal);
        menuSucursales.add(itemBajaSucursal);
        menuSucursales.add(itemModificacionSucursal);

        JMenu menuPracticas = new JMenu("Prácticas");
        JMenuItem itemAltaPractica = new JMenuItem("Alta");
        JMenuItem itemBajaPractica = new JMenuItem("Baja");
        JMenuItem itemModificacionPractica = new JMenuItem("Modificación");
        menuPracticas.add(itemAltaPractica);
        menuPracticas.add(itemBajaPractica);
        menuPracticas.add(itemModificacionPractica);

        JMenu menuPeticiones = new JMenu("Peticiones");
        JMenuItem itemAltaPeticion = new JMenuItem("Alta");
        JMenuItem itemBajaPeticion = new JMenuItem("Baja");
        JMenuItem itemModificacionPeticion = new JMenuItem("Modificación");
        menuPeticiones.add(itemAltaPeticion);
        menuPeticiones.add(itemBajaPeticion);
        menuPeticiones.add(itemModificacionPeticion);

        JMenu menuUsuarios = new JMenu("Usuarios");
        JMenuItem itemAltaUsuario = new JMenuItem("Alta");
        JMenuItem itemBajaUsuario = new JMenuItem("Baja");
        JMenuItem itemModificacionUsuario = new JMenuItem("Modificación");
        menuUsuarios.add(itemAltaUsuario);
        menuUsuarios.add(itemBajaUsuario);
        menuUsuarios.add(itemModificacionUsuario);

        JMenu menuResultados = new JMenu("Resultados");
        JMenuItem itemAltaResultado = new JMenuItem("Alta");
        JMenuItem itemBajaResultado = new JMenuItem("Baja");
        JMenuItem itemModificacionResultado = new JMenuItem("Modificación");
        menuResultados.add(itemAltaResultado);
        menuResultados.add(itemBajaResultado);
        menuResultados.add(itemModificacionResultado);

        menuBar.add(menuPacientes);
        menuBar.add(menuSucursales);
        menuBar.add(menuPracticas);
        menuBar.add(menuPeticiones);
        menuBar.add(menuUsuarios);
        menuBar.add(menuResultados);

        setJMenuBar(menuBar);

        itemAltaPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PacienteForm(pacienteController, null).setVisible(true);
            }
        });

        itemBajaPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar paciente
            }
        });

        itemModificacionPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar paciente
            }
        });

        itemAltaSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SucursalForm(sucursalController, null).setVisible(true);
            }
        });

        itemBajaSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar sucursal
            }
        });

        itemModificacionSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar sucursal
            }
        });

        itemAltaPractica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PracticaForm(practicaController, null).setVisible(true);
            }
        });

        itemBajaPractica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar práctica
            }
        });

        itemModificacionPractica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar práctica
            }
        });

        itemAltaPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PeticionForm(peticionController, pacienteController, practicaController, null).setVisible(true);
            }
        });

        itemBajaPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar petición
            }
        });

        itemModificacionPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar petición
            }
        });

        itemAltaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UsuarioForm(usuarioController, null).setVisible(true);
            }
        });

        itemBajaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar usuario
            }
        });

        itemModificacionUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar usuario
            }
        });

        itemAltaResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ResultadoForm(resultadoController, peticionController, null).setVisible(true);
            }
        });

        itemBajaResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar resultado
            }
        });

        itemModificacionResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para modificar resultado
            }
        });
    }
}