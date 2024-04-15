public class Limpieza extends Producto {
    private String categoria;

    public Limpieza(String nombre, double precio, String fechaImportacion, String numeroSerie, int stock, String categoria) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.categoria = categoria;
    }

    // Métodos específicos para productos de limpieza
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}