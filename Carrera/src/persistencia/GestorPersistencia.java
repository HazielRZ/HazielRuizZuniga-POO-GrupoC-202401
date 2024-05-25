package persistencia;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import utils.LocalDateAdapter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    public static <T> void guardar(List<T> entidades, String nombreArchivo) throws IOException {
        Type tipoLista = TypeToken.getParameterized(ArrayList.class, entidades.get(0).getClass()).getType();
        String json = gson.toJson(entidades, tipoLista);

        File archivo = new File(nombreArchivo);
        archivo.createNewFile();

        Files.write(Paths.get(nombreArchivo), json.getBytes());
    }

    public static <T> List<T> cargar(String nombreArchivo, Class<T> claseEntidad) throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(nombreArchivo)));
        Type tipoLista = TypeToken.getParameterized(ArrayList.class, claseEntidad).getType();
        return gson.fromJson(json, tipoLista);
    }

    // Método para obtener la instancia de Gson configurada
    public static Gson getGson() {
        return gson;
    }
}
