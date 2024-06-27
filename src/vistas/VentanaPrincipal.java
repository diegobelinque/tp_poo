package vistas;

import controladores.*;
import modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
                String dni = JOptionPane.showInputDialog("Ingrese el DNI del paciente a eliminar:");
                if (dni != null && !dni.isEmpty()) {
                    pacienteController.eliminarPaciente(dni);
                    JOptionPane.showMessageDialog(null, "Paciente eliminado exitosamente.");
                }
            }
        });

        itemModificacionPaciente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = JOptionPane.showInputDialog("Ingrese el DNI del paciente a modificar:");
                if (dni != null && !dni.isEmpty()) {
                    Paciente paciente = pacienteController.buscarPaciente(dni);
                    if (paciente != null) {
                        new PacienteForm(pacienteController, paciente).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Paciente no encontrado.");
                    }
                }
            }
        });

        itemAltaSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SucursalForm(sucursalController, null).setVisible(true);
            }
        });

        itemBajaSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = JOptionPane.showInputDialog("Ingrese el número de la sucursal a eliminar:");
                if (numero != null && !numero.isEmpty()) {
                    sucursalController.eliminarSucursal(Integer.parseInt(numero));
                    JOptionPane.showMessageDialog(null, "Sucursal eliminada exitosamente.");
                }
            }
        });

        itemModificacionSucursal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String numero = JOptionPane.showInputDialog("Ingrese el número de la sucursal a modificar:");
                if (numero != null && !numero.isEmpty()) {
                    Sucursal sucursal = sucursalController.buscarSucursal(Integer.parseInt(numero));
                    if (sucursal != null) {
                        new SucursalForm(sucursalController, sucursal).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
                    }
                }
            }
        });

        itemAltaPractica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PracticaForm(practicaController, null).setVisible(true);
            }
        });

        itemBajaPractica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Ingrese el código de la práctica a eliminar:");
                if (codigo != null && !codigo.isEmpty()) {
                    practicaController.eliminarPractica(codigo);
                    JOptionPane.showMessageDialog(null, "Práctica eliminada exitosamente.");
                }
            }
        });

        itemModificacionPractica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Ingrese el código de la práctica a modificar:");
                if (codigo != null && !codigo.isEmpty()) {
                    Practica practica = practicaController.buscarPractica(codigo);
                    if (practica != null) {
                        new PracticaForm(practicaController, practica).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Práctica no encontrada.");
                    }
                }
            }
        });

        itemAltaPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PeticionForm(peticionController, pacienteController, practicaController, null).setVisible(true);
            }
        });

        itemBajaPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = JOptionPane.showInputDialog("Ingrese el DNI del paciente de la petición a eliminar:");
                String fecha = JOptionPane.showInputDialog("Ingrese la fecha de la petición a eliminar (dd/MM/yyyy):");
                if (dni != null && !dni.isEmpty() && fecha != null && !fecha.isEmpty()) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaCarga = dateFormat.parse(fecha);
                        peticionController.eliminarPeticion(dni, fechaCarga);
                        JOptionPane.showMessageDialog(null, "Petición eliminada exitosamente.");
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Por favor, use el formato dd/MM/yyyy.");
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });

        itemModificacionPeticion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = JOptionPane.showInputDialog("Ingrese el DNI del paciente de la petición a modificar:");
                String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de la petición a modificar (dd/MM/yyyy):");

                if (dni != null && !dni.isEmpty() && fechaStr != null && !fechaStr.isEmpty()) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date fecha = dateFormat.parse(fechaStr);

                        Peticion peticion = peticionController.buscarPeticion(dni, fecha);
                        if (peticion != null) {
                            new PeticionForm(peticionController, pacienteController, practicaController, peticion).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Petición no encontrada.");
                        }
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Ingrese la fecha en formato dd/MM/yyyy.");
                    }
                }
            }
        });

        itemAltaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UsuarioForm(usuarioController, null).setVisible(true);
            }
        });

        itemBajaUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario a eliminar:");
                if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
                    usuarioController.eliminarUsuario(nombreUsuario);
                    JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
                }
            }
        });

        itemModificacionUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre de usuario a modificar:");
                if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
                    Usuario usuario = usuarioController.buscarUsuario(nombreUsuario);
                    if (usuario != null) {
                        new UsuarioForm(usuarioController, usuario).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    }
                }
            }
        });

        itemAltaResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ResultadoForm(resultadoController, peticionController, null).setVisible(true);
            }
        });

        itemBajaResultado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dni = JOptionPane.showInputDialog("Ingrese el DNI del paciente de la petición del resultado a eliminar:");
                String fechaStr = JOptionPane.showInputDialog("Ingrese la fecha de carga de la petición del resultado a eliminar (dd/MM/yyyy):");

                if (dni != null && !dni.isEmpty() && fechaStr != null && !fechaStr.isEmpty()) {
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaCarga = null;
                    try {
                        fechaCarga = df.parse(fechaStr);
                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use el formato dd/MM/yyyy.");
                        return;
                    }

                    Peticion peticion = peticionController.buscarPeticion(dni, fechaCarga);
                    if (peticion != null) {
                        try {
                            resultadoController.eliminarResultado(peticion);
                            JOptionPane.showMessageDialog(null, "Resultado eliminado exitosamente.");
                        } catch (IllegalArgumentException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró la petición especificada.");
                    }
                }
            }
        });

        itemModificacionResultado.addActionListener(e -> {
                    String idPeticion = JOptionPane.showInputDialog("Ingrese el ID de la petición del resultado a modificar:");
                    if (idPeticion != null && !idPeticion.isEmpty()) {
                        String[] partes = idPeticion.split("-");
                        if (partes.length == 2) {
                            String dniPaciente = partes[0].trim();
                            String fechaCargaStr = partes[1].trim();

                            try {
                                Date fechaCarga = new SimpleDateFormat("dd/MM/yyyy").parse(fechaCargaStr);

                                Peticion peticion = peticionController.buscarPeticion(dniPaciente, fechaCarga);

                                if (peticion != null) {
                                    Resultado resultado = resultadoController.buscarResultado(peticion);

                                    if (resultado != null) {
                                        new ResultadoForm(resultadoController, peticionController, resultado).setVisible(true);
                                        return; // Salir del método actionPerformed después de mostrar el formulario
                                    }
                                }

                                JOptionPane.showMessageDialog(null, "No se encontró ningún resultado para la petición especificada.");
                            } catch (ParseException ex) {
                                JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Utilice dd/MM/yyyy.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Formato de entrada inválido para ID de petición. Debe ser DNI-FechaCarga.");
                        }
                    }
                }
        );
    }
}