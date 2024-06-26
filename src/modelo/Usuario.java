package modelo;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {
    private String nombreUsuario;
    private String email;
    private String password;
    private String nombre;
    private String domicilio;
    private String dni;
    private Date fechaNacimiento;
    private String rol;

    public Usuario(String nombreUsuario, String email, String password, String nombre, String domicilio, String dni, Date fechaNacimiento, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.rol = rol;
    }

    // Getters y Setters
    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDomicilio() { return domicilio; }
    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}