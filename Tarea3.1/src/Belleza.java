class Belleza extends Producto {
    private String tipoProducto;

    public Belleza(String nombre, double precio, String fechaImportacion, String numeroSerie, int stock, String tipoProducto) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.tipoProducto = tipoProducto;
    }

    // Métodos específicos para productos de belleza
    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
