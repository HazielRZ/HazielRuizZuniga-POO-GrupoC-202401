
package Usuarios;

import Usuarios.Utils.Rol;



public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private final int id;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final Rol rol; // Cliente, asistente, gerente
    private final String nombreUsuario;
    private final String contrasena;

    public Usuario(String nombre, String apellido, String telefono, Rol rol, String nombreUsuario, String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.rol = rol;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        CANTIDAD_USUARIOS++;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public Rol getRol() {
        return rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String mostrarInfo() {
        return String.format("ID: %d\nNombre completo: %s %s\nTeléfono: %s\nNombre de usuario: %s\nRol: %s",
                id, nombre, apellido, telefono, nombreUsuario, rol);
    }

    @Override
    public String toString() {
        return String.format("ID: %d\nNombre completo: %s %s\nTeléfono: %s\nNombre de usuario: %s\nContraseña: %s\nRol: %s",
                id, nombre, apellido, telefono, nombreUsuario, contrasena, rol);
    }
}
