import Fachada.Fachada;
import InicioSesion.InicioSesion;
import Modelo.Carrera;
import Modelo.Coordinador;
import Modelo.Usuario;

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
        System.out.print("Ingrese su nombre de usuario: ");
        scanner.nextLine();
        String nombreUsuario;
        System.out.print("Ingrese su contraseña: ");
        scanner.nextLine();
        String contrasena;

        Fachada fachada = new Fachada(); // Crear la fachada
        // ... (cargar carreras desde JSON)
        List<Carrera> carreras = new ArrayList<>();

        // Cargar carreras desde JSON si el archivo existe
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

            // Guardar carreras en JSON
            try {
                Carrera.guardarCarreras(carreras, "carreras.json");
            } catch (IOException e) {
                System.err.println("Error al guardar carreras en JSON: " + e.getMessage());
            }
        }

        List<Coordinador> coordinadores = new ArrayList<>();

        // Crear coordinadores de ejemplo
        Coordinador coordinadorISC = new Coordinador(
                "José Manuel", "Cuin Jacuinde", LocalDate.parse("1980-05-12"), "M", "Morelia", "MICHOACÁN",
                "Av. Tecnológico 1500", 50000.0, carreras.get(0),"jmcuin", "123" // ISC
        );
        Coordinador coordinadorELC = new Coordinador(
                "Eder", "Rivera Cisneros", LocalDate.parse("1985-08-22"), "M", "Morelia", "MICHOACÁN",
                "Calle Revolución 320", 48000.0, carreras.get(1),"Edriv", "123" // ELC
        );
        Coordinador coordinadorIMAT = new Coordinador(
                "Juvenal", "Maldonado Pérez", LocalDate.parse("1978-03-18"), "M", "Morelia", "MICHOACÁN",
                "Blvd. García de León 789", 52000.0, carreras.get(2),"Jvmp", "123" // IMAT
        );

        coordinadores.add(coordinadorISC);
        coordinadores.add(coordinadorELC);
        coordinadores.add(coordinadorIMAT);

        // Guardar coordinadores en JSON
        Coordinador.guardarCoordinadores(coordinadores, "coordinadores.json");

        while (true) { // Bucle para mantener el menú activo hasta que el usuario cierre sesión
            System.out.print("Ingrese su nombre de usuario (o '2' para terminar): ");
             nombreUsuario = scanner.nextLine();

            if (nombreUsuario.equalsIgnoreCase("2")) {
                break; // Salir del programa
            }

            System.out.print("Ingrese su contraseña: ");
             contrasena = scanner.nextLine();

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

