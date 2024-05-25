package Modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import persistencia.GestorPersistencia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class Graduado {
    private Alumno alumno;
    private LocalDate fechaGraduacion;
    private double promedioFinal;
    private String generacionGraduacion;

    public Graduado(Alumno alumno, LocalDate fechaGraduacion, double promedioFinal, String generacionGraduacion) {
        this.alumno = alumno;
        this.fechaGraduacion = fechaGraduacion;
        this.promedioFinal = promedioFinal;
        this.generacionGraduacion = generacionGraduacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public LocalDate getFechaGraduacion() {
        return fechaGraduacion;
    }

    public void setFechaGraduacion(LocalDate fechaGraduacion) {
        this.fechaGraduacion = fechaGraduacion;
    }

    public double getPromedioFinal() {
        return promedioFinal;
    }

    public void setPromedioFinal(double promedioFinal) {
        this.promedioFinal = promedioFinal;
    }

    public String getGeneracionGraduacion() {
        return generacionGraduacion;
    }

    public void setGeneracionGraduacion(String generacionGraduacion) {
        this.generacionGraduacion = generacionGraduacion;
    }

    public static List<Graduado> cargarGraduados(String nombreArchivo) {
        try {
            Gson gson = GestorPersistencia.getGson();
            String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
            return gson.fromJson(json, new TypeToken<List<Graduado>>() {
            }.getType());
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar coordinadores desde JSON: " + e.getMessage());
        }
    }
}
