public class Electrodomestico extends Producto {
    private String tipo;

    public Electrodomestico(String nombre, double precio, String fechaImportacion, String numeroSerie, int stock, String tipo) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.tipo = tipo;
    }

    // Métodos específicos para electrodomésticos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}