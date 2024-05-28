package utils;

import Modelo.Carrera;
import Modelo.Grupo;
import Modelo.Semestre;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SemestreAdapter extends TypeAdapter<Semestre> {

    @Override
    public void write(JsonWriter out, Semestre semestre) throws IOException {
        out.beginObject();
        out.name("idSemestre").value(semestre.getIdSemestre());
        out.name("numeroSemestre").value(semestre.getNumeroSemestre());
        out.name("carrera").value(semestre.getCarrera().getIdCarrera()); // Guardar el ID de la carrera
        // Guardar los IDs de los grupos
        out.name("grupos").beginArray();
        for (Grupo grupo : semestre.getGrupos()) {
            out.value(grupo.getIdGrupo());
        }
        out.endArray();
        out.endObject();
    }

    @Override
    public Semestre read(JsonReader in) throws IOException {
        in.beginObject();
        int idSemestre = 0;
        int numeroSemestre = 0;
        int idCarrera = 0;
        List<Integer> idsGrupos = new ArrayList<>();

        while (in.hasNext()) {
            String nombreAtributo = in.nextName();
            switch (nombreAtributo) {
                case "idSemestre":
                    idSemestre = in.nextInt();
                    break;
                case "numeroSemestre":
                    numeroSemestre = in.nextInt();
                    break;
                case "carrera":
                    idCarrera = in.nextInt();
                    break;
                case "grupos":
                    in.beginArray();
                    while (in.hasNext()) {
                        idsGrupos.add(in.nextInt());
                    }
                    in.endArray();
                    break;
            }
        }
        in.endObject();

        // Obtener la carrera y los grupos por ID (debes implementar estos métodos en la Fachada)
        Carrera carrera = null; //fachada.obtenerCarreraPorId(idCarrera);
        List<Grupo> grupos = new ArrayList<>();
        // for (int idGrupo : idsGrupos) {
        //     grupos.add(fachada.obtenerGrupoPorId(idGrupo));
        // }

        return new Semestre(idSemestre, numeroSemestre, carrera, grupos);
    }

}
