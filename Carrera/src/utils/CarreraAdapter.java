package utils;

import Modelo.Carrera;
import Modelo.Coordinador;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;

public class CarreraAdapter extends TypeAdapter<Carrera> {
    @Override
    public void write(JsonWriter out, Carrera carrera) throws IOException {
        out.beginObject();
        out.name("idCarrera").value(carrera.getIdCarrera());
        out.name("nombre").value(carrera.getNombre());
        out.name("cantidadGrupos").value(carrera.getCantidadGrupos());
        out.name("cantidadAlumnos").value(carrera.getCantidadAlumnos());
        out.name("cantidadMaterias").value(carrera.getCantidadMaterias());
        out.name("fechaCreacion").value(carrera.getFechaCreacion().toString()); // Convertir LocalDate a String
        if (carrera.getCoordinador() != null) { // Verificar si hay coordinador asignado
            out.name("coordinador").value(carrera.getCoordinador().getIdUsuario()); // Guardar solo el ID del coordinador
        } else {
            out.name("coordinador").nullValue();
        }
        out.endObject();
    }

    @Override
    public Carrera read(JsonReader in) throws IOException {
        in.beginObject();
        int idCarrera = 0;
        String nombre = null;
        int cantidadGrupos = 0;
        int cantidadAlumnos = 0;
        int cantidadMaterias = 0;
        LocalDate fechaCreacion = null;
        int idCoordinador = 0; // Leer el ID del coordinador

        while (in.hasNext()) {
            String nombreAtributo = in.nextName();
            switch (nombreAtributo) {
                case "idCarrera":
                    idCarrera = in.nextInt();
                    break;
                case "nombre":
                    nombre = in.nextString();
                    break;
                case "cantidadGrupos":
                    cantidadGrupos = in.nextInt();
                    break;
                case "cantidadAlumnos":
                    cantidadAlumnos = in.nextInt();
                    break;
                case "cantidadMaterias":
                    cantidadMaterias = in.nextInt();
                    break;
                case "fechaCreacion":
                    fechaCreacion = LocalDate.parse(in.nextString());
                    break;
                case "coordinador":
                    if (in.peek() != JsonToken.NULL) {
                        idCoordinador = in.nextInt(); // Leer el ID del coordinador si no es null
                    } else {
                        in.nextNull();
                    }
                    break;
            }
        }
        in.endObject();

        // Obtener el coordinador por ID (debes implementar este método en la Fachada)
        Coordinador coordinador = null; //fachada.obtenerCoordinadorPorId(idCoordinador);

        return new Carrera(idCarrera, nombre, cantidadGrupos, cantidadAlumnos, cantidadMaterias, fechaCreacion, coordinador);
    }
}