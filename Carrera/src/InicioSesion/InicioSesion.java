package InicioSesion;

import Modelo.Alumno;
import Modelo.Coordinador;
import Modelo.Profesor;
import Modelo.Usuario;

import java.util.List;

public class InicioSesion {
    private final List<Alumno> alumnos;
    private final List<Profesor> profesores;
    private final List<Coordinador> coordinadores;

    public InicioSesion(List<Alumno> alumnos, List<Profesor> profesores, List<Coordinador> coordinadores) {
        this.alumnos = alumnos;
        this.profesores = profesores;
        this.coordinadores = coordinadores;
    }

    public Usuario iniciarSesion(String nombreUsuario, String contrasena) {
        // Buscar en la lista de alumnos
        for (Alumno alumno : alumnos) {
            if (alumno.getNombreUsuario().equals(nombreUsuario) && alumno.getContrasena().equals(contrasena)) {
                return alumno;
            }
        }

        // Buscar en la lista de profesores
        for (Profesor profesor : profesores) {
            if (profesor.getNombreUsuario().equals(nombreUsuario) && profesor.getContrasena().equals(contrasena)) {
                return profesor;
            }
        }

        // Buscar en la lista de coordinadores
        for (Coordinador coordinador : coordinadores) {
            if (coordinador.getNombreUsuario().equals(nombreUsuario) && coordinador.getContrasena().equals(contrasena)) {
                return coordinador;
            }
        }

        // Si no se encuentra el usuario, devolver null
        return null;
    }
}