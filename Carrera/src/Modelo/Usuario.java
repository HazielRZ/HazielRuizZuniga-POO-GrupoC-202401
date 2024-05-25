package Modelo;

import utils.ValidadorCURP;

import java.time.LocalDate;

public class Usuario {
    int idUsuario;
    protected String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento; // Cambiado a LocalDate
    private String sexo; // "H" o "M"
    private String ciudad;
    private String estado;
    String curp;
    private String direccion;
    private LocalDate fechaRegistro; // Cambiado a LocalDate
    private String nombreUsuario; // Para el inicio de sesión
    private String contrasena; // Para el inicio de sesión
    private String rol; // "Alumno", "Profesor" o "Coordinador"

    // Constructor
    public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String ciudad,
                   String estado, String direccion, LocalDate fechaRegistro, String rol, String nombreUsuario, String contrasena) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.ciudad = ciudad;
        this.estado = estado;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.rol = rol;
        this.curp = ValidadorCURP.generarCURP(this); // Generar CURP automáticament
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

