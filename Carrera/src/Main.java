import Fachada.Fachada;
import InicioSesion.InicioSesion;
import Modelo.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cargar carreras desde JSON (una sola vez, fuera del bucle)
        List<Carrera> carreras = new ArrayList<>();
        if (Files.exists(Paths.get("carreras.json"))) {
            try {
                carreras = Carrera.cargarCarreras("carreras.json");
            } catch (IOException e) {
                System.err.println("Error al cargar carreras desde JSON: " + e.getMessage());
            }
        } else {
            // Crear carreras iniciales si el archivo no existe
            carreras.add(new Carrera("Ingeniería en Sistemas Computacionales", null)); // Coordinador se asignará después
            carreras.add(new Carrera("Ingeniería en Materiales", null));
            carreras.add(new Carrera("Ingeniería Electrónica", null));
        }
        List<Coordinador> coordinadores = getCoordinadors(carreras);

        // Asignar coordinadores a las carreras
        carreras.get(0).setCoordinador(coordinadores.get(0));
        carreras.get(1).setCoordinador(coordinadores.get(1));
        carreras.get(2).setCoordinador(coordinadores.get(2));

        // Guardar carreras en JSON
        try {
            Carrera.guardarCarreras(carreras, "carreras.json");
        } catch (IOException e) {
            System.err.println("Error al guardar carreras en JSON: " + e.getMessage());
        }

        // Guardar coordinadores en JSON
        Coordinador.guardarCoordinadores(coordinadores, "coordinadores.json");

        Fachada fachada = new Fachada(); // Crear la fachada después de cargar carreras y coordinadores

        // Cargar o crear semestres
        List<Semestre> semestres = new ArrayList<>();
        if (Files.exists(Paths.get("semestres.json"))) {
            try {
                semestres = Semestre.cargarSemestres("semestres.json");
            } catch (IOException e) {
                System.err.println("Error al cargar semestres desde JSON: " + e.getMessage());
            }
        } else {
            // Crear semestres iniciales (uno por carrera)
            for (Carrera carrera : carreras) {
                for (int i = 1; i <= 3; i++) {
                    semestres.add(new Semestre(i, carrera));
                }
            }
            try {
                Semestre.guardarSemestres(semestres, "semestres.json");
            } catch (IOException e) {
                System.err.println("Error al guardar semestres en JSON: " + e.getMessage());
            }
        }

        // Cargar o crear grupos
        List<Grupo> grupos = new ArrayList<>();
        if (Files.exists(Paths.get("grupos.json"))) {
            try {
                grupos = Grupo.cargarGrupos("grupos.json");
            } catch (IOException e) {
                System.err.println("Error al cargar grupos desde JSON: " + e.getMessage());
            }
        } else {
            // Crear un grupo de ejemplo por carrera
            for (Carrera carrera : carreras) {
                grupos.add(new Grupo("A", carrera, semestres.get(0))); // Semestre 1
            }
            try {
                Grupo.guardarGrupos(grupos, "grupos.json");
            } catch (IOException e) {
                System.err.println("Error al guardar grupos en JSON: " + e.getMessage());
            }
        }

        // Cargar o crear alumnos
        List<Alumno> alumnos = new ArrayList<>();
        if (Files.exists(Paths.get("alumnos.json"))) {
            alumnos = Alumno.cargarAlumnos("alumnos.json");
        } else {
            // Crear un alumno de ejemplo
            Alumno alumnoEjemplo = new Alumno("Juan", "Pérez Gómez", LocalDate.parse("2000-01-15"), "M", "Morelia", "MICHOACÁN",
                    "Calle 123", carreras.get(0), semestres.get(0), grupos.get(0), "juanperez", "contraseña123");
            alumnos.add(alumnoEjemplo);
            Alumno.guardarAlumnos(alumnos, "alumnos.json");
        }

        while (true) { // Bucle para mantener el menú activo hasta que el usuario cierre sesión
            System.out.print("Ingrese su nombre de usuario (o 'salir' para terminar): ");
            String nombreUsuario = scanner.nextLine();

            if (nombreUsuario.equalsIgnoreCase("salir")) {
                break; // Salir del programa
            }

            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            try {
                InicioSesion inicioSesion = new InicioSesion(fachada.obtenerAlumnos(), fachada.obtenerProfesores(), fachada.obtenerCoordinadores());
                Usuario usuarioActual = inicioSesion.iniciarSesion(nombreUsuario, contrasena);

                if (usuarioActual != null) {
                    fachada.setUsuarioActual(usuarioActual);
                    MenuPrincipal menuPrincipal = new MenuPrincipal(fachada, usuarioActual); // Pasar el usuarioActual
                    menuPrincipal.mostrar();

                    fachada.setUsuarioActual(null);
                } else {
                    System.out.println("Credenciales incorrectas. Intente nuevamente.");
                }
            } catch (RuntimeException e) {
                System.err.println("Error durante el inicio de sesión: " + e.getMessage());
            }
        }

        scanner.close();
    }
}

