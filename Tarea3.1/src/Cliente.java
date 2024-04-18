public class Cliente {
    private static int siguienteId = 1;
    private final int id;
    private final String nombre;

    public Cliente(String nombre) {
        this.id = siguienteId++;
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}