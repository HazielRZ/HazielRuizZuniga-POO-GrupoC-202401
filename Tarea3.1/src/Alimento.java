public class Alimento extends Producto {
    private String tipoAlimento;

    public Alimento(String nombre, double precio, String fechaImportacion, String numeroSerie, int stock, String tipoAlimento) {
        super(nombre, precio, fechaImportacion, numeroSerie, stock);
        this.tipoAlimento = tipoAlimento;
    }

    // Métodos específicos para alimentos
    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }
}