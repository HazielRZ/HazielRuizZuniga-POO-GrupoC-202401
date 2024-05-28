package utils;

import Modelo.Alumno;
import Modelo.Grupo;
import Modelo.Materia;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GrupoAdapter extends TypeAdapter<Grupo> {
    @Override
    public void write(JsonWriter out, Grupo grupo) throws IOException {
        out.beginObject();
        out.name("idGrupo").value(grupo.getIdGrupo());
        out.name("tipoGrupo").value(grupo.getTipoGrupo());
        out.name("carrera").value(grupo.getCarrera().getIdCarrera()); // Guardar el ID de la carrera
        // Guardar los IDs de los alumnos
        out.name("alumnos").beginArray();
        for (Alumno alumno : grupo.getAlumnos()) {
            out.value(alumno.getIdUsuario());
        }
        out.endArray();
        // Guardar los IDs de las materias
        out.name("materias").beginArray();
        for (Materia materia : grupo.getMaterias()) {
            out.value(materia.getIdMateria());
        }
        out.endArray();
        out.name("semestre").value(grupo.getSemestre().getIdSemestre()); // Guardar el ID del semestre
        out.endObject();
    }

    @Override
    public Grupo read(JsonReader in) throws IOException {
        // ... (deserializar los atributos de Grupo desde el JSON)
    }
}