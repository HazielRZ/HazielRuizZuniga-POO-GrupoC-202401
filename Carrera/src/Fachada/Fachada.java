package Fachada;

import persistencia.GestorPersistencia;
import Modelo.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fachada {
    private Usuario usuarioActual;

    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    private List<Alumno> alumnos;
    private List<Profesor> profesores;
    private List<Coordinador> coordinadores;
    private List<Carrera> carreras;
    private List<Semestre> semestres;
    private List<Grupo> grupos;
    private List<Materia> materias;
    private List<Graduado> graduados;
    private List<Calificacion> calificaciones;

    public Fachada() {
        try {
            this.alumnos = GestorPersistencia.cargar("alumnos.json", Alumno.class);
            this.profesores = GestorPersistencia.cargar("profesores.json", Profesor.class);
            this.coordinadores = GestorPersistencia.cargar("coordinadores.json", Coordinador.class);
            this.carreras = GestorPersistencia.cargar("carreras.json", Carrera.class);
            this.semestres = GestorPersistencia.cargar("semestres.json", Semestre.class);
            this.grupos = GestorPersistencia.cargar("grupos.json", Grupo.class);
            this.materias = GestorPersistencia.cargar("materias.json", Materia.class);
            this.calificaciones = GestorPersistencia.cargar("calificaciones.json", Calificacion.class);
            this.graduados = GestorPersistencia.cargar("graduados.json", Graduado.class);
        } catch (IOException e) {
            System.err.println("Error al cargar datos: " + e.getMessage());
            // Manejar el error (crear archivos vacíos, mostrar mensaje al usuario, etc.)
        }
    }

    // Métodos para interactuar con alumnos
    public void registrarAlumno(Alumno alumno) {
        Alumno.crearAlumno(alumno, this.alumnos);
    }

    public List<Alumno> obtenerAlumnos() {
        return alumnos;
    }

    // Métodos para interactuar con profesores
    public void registrarProfesor(Profesor profesor) {
        Profesor.crearProfesor(profesor, this.profesores);
    }

    public List<Profesor> obtenerProfesores() {
        return profesores;
    }

    // Métodos para interactuar con coordinadores
    public void registrarCoordinador(Coordinador coordinador) {
        Coordinador.crearCoordinador(coordinador, this.coordinadores);
    }

    public List<Coordinador> obtenerCoordinadores() {
        return coordinadores;
    }

    public void registrarCalificacion(Calificacion calificacion) {
        if (usuarioActual instanceof Profesor && ((Profesor) usuarioActual).getMateriasImpartidas().contains(calificacion.getMateria())) {
            calificaciones.add(calificacion);
            try {
                GestorPersistencia.guardar(calificaciones, "calificaciones.json");
            } catch (IOException e) {
                throw new RuntimeException("Error al guardar calificaciones: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("Solo el profesor de la materia puede registrar calificaciones.");
        }
    }

    public List<Calificacion> obtenerCalificaciones(Grupo grupo, Materia materia, Semestre semestre, Boolean aprobatoria) {
        List<Calificacion> calificacionesFiltradas = new ArrayList<>(calificaciones);
        if (grupo != null) {
            calificacionesFiltradas = Calificacion.filtrarPorGrupo(calificacionesFiltradas, grupo);
        }
        if (materia != null) {
            calificacionesFiltradas = Calificacion.filtrarPorMateria(calificacionesFiltradas, materia);
        }
        if (semestre != null) {
            calificacionesFiltradas = Calificacion.filtrarPorSemestre(calificacionesFiltradas, semestre);
        }
        if (aprobatoria != null) {
            calificacionesFiltradas = Calificacion.filtrarPorEstado(calificacionesFiltradas, aprobatoria);
        }
        return calificacionesFiltradas;
    }

    public List<Calificacion> obtenerCalificacionesPorAlumno(int idAlumno) {
        return calificaciones.stream()
                .filter(calificacion -> calificacion.getAlumno().getIdUsuario() == idAlumno)
                .collect(Collectors.toList());
    }

    public void registrarGraduado(Alumno alumno) throws IOException {
        // Verificar que el alumno esté en el último semestre y haya aprobado todas las materias
        if (alumno.getSemestre().getNumeroSemestre() == 3 && alumno.getPromedio() >= 70) {
            // Calcular la generación de graduación (puedes usar la fecha actual)
            LocalDate fechaActual = LocalDate.now();
            int mesActual = fechaActual.getMonthValue();
            String generacion = (mesActual <= 6) ? "Ene-Jun " : "Ago-Dic ";
            generacion += fechaActual.getYear();

            // Crear el objeto Graduado
            Graduado graduado = new Graduado(alumno, fechaActual, alumno.getPromedio(), generacion);

            // Agregar el graduado a la lista y guardar en JSON
            graduados.add(graduado);
            guardarGraduados(graduados, "graduados.json");

            // Eliminar al alumno de la lista de alumnos (opcional)
            // alumnos.remove(alumno);
            // Alumno.guardarAlumnos(alumnos, "alumnos.json");
        } else {
            throw new RuntimeException("El alumno no cumple los requisitos para graduarse.");
        }
    }

    // Método para guardar graduados en JSON (similar a guardarAlumnos)
    public static void guardarGraduados(List<Graduado> graduados, String nombreArchivo) throws IOException {
        // ... (implementación similar a guardarAlumnos)
    }


    // Método para avanzar semestre (solo para coordinadores)
    public void avanzarSemestre(Grupo grupo) {
        if (usuarioActual instanceof Coordinador && ((Coordinador) usuarioActual).getCarrera().equals(grupo.getCarrera())) {
            grupo.getSemestre().avanzarSemestre(grupo);
        } else {
            throw new RuntimeException("Solo el coordinador de la carrera puede avanzar el semestre.");
        }
    }
    // Métodos para interactuar con carreras, semestres, grupos, materias y calificaciones
    // ... (agregar métodos según las necesidades de los menús)
}
