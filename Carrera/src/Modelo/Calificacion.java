package Modelo;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Calificacion {
    private Alumno alumno;
    private Materia materia;
    private double valor;
    private boolean aprobatoria;

    // Constructor
    public Calificacion(Alumno alumno, Materia materia, double valor) {
        this.alumno = alumno;
        this.materia = materia;
        this.valor = valor;
        this.aprobatoria = (valor >= 70);
    }

    public static void crearCalificacion(Calificacion calificacion, List<Calificacion> calificaciones) {
        //metodo para guardarla
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAprobatoria() {
        return aprobatoria;
    }

    public void setAprobatoria(boolean aprobatoria) {
        this.aprobatoria = aprobatoria;
    }

    // Métodos para guardar/cargar calificaciones en JSON
    public static void guardarCalificaciones(List<Calificacion> calificaciones, String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(calificaciones);
        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public static List<Calificacion> cargarCalificaciones(String nombreArchivo) throws IOException {
        Gson gson = new Gson();
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        return gson.fromJson(json, new TypeToken<List<Calificacion>>() {
        }.getType());
    }

    public static List<Calificacion> filtrarPorGrupo(List<Calificacion> calificaciones, Grupo grupo) {
        return calificaciones.stream()
                .filter(calificacion -> calificacion.getMateria().getGrupo().equals(grupo))
                .collect(Collectors.toList());
    }

    public static List<Calificacion> filtrarPorMateria(List<Calificacion> calificaciones, Materia materia) {
        return calificaciones.stream()
                .filter(calificacion -> calificacion.getMateria().equals(materia))
                .collect(Collectors.toList());
    }

    public static List<Calificacion> filtrarPorSemestre(List<Calificacion> calificaciones, Semestre semestre) {
        return calificaciones.stream()
                .filter(calificacion -> calificacion.getMateria().getSemestre().equals(semestre))
                .collect(Collectors.toList());
    }

    public static List<Calificacion> filtrarPorEstado(List<Calificacion> calificaciones, boolean aprobatoria) {
        return calificaciones.stream()
                .filter(calificacion -> calificacion.isAprobatoria() == aprobatoria)
                .collect(Collectors.toList());
    }
}
