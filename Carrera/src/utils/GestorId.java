package utils;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GestorId {

    private int contadorCarreras = 0;
    private int contadorSemestres = 0;
    private int contadorGrupos = 0;
    private int contadorMaterias = 0;
    private int contadorAlumnos = 0;
    private int contadorProfesores = 0;

    // Singleton para asegurar una única instancia del utils.GestorId
    private static GestorId instancia = null;

    private GestorId() {
    }
    public static GestorId getInstancia() {
        if (instancia == null) {
            instancia = new GestorId();
            try {
                instancia.cargarContadores("contadores.json");
            } catch (IOException e) {
                // Si el archivo no existe, crearlo con valores iniciales
                try {
                    instancia.guardarContadores("contadores.json");
                } catch (IOException ex) {
                    System.err.println("Error al crear el archivo de contadores: " + ex.getMessage());
                }
            }
        }
        return instancia;
    }

    // Métodos para generar IDs
    public int generarIdCarrera() {
        return contadorCarreras++;
    }

    public int generarIdSemestre() {
        return contadorSemestres++;
    }

    public int generarIdGrupo() {
        return contadorGrupos++;
    }

    public int generarIdMateria() {
        return contadorMaterias++;
    }

    public int generarIdAlumno() {
        return contadorAlumnos++;
    }

    public int generarIdProfesor() {
        return contadorProfesores++;
    }

    // Métodos para guardar/cargar contadores desde/hacia JSON
    public void guardarContadores(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public void cargarContadores(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        GestorId datos = gson.fromJson(json, GestorId.class);
        this.contadorCarreras = datos.contadorCarreras;
        this.contadorSemestres = datos.contadorSemestres;
        this.contadorGrupos = datos.contadorGrupos;
        this.contadorMaterias = datos.contadorMaterias;
        this.contadorAlumnos = datos.contadorAlumnos;
        this.contadorProfesores = datos.contadorProfesores;
    }
}