class Producto {
    private static int siguienteId = 1;
    protected int id;
    protected String nombre;
    protected double precio;
    protected String fechaImportacion;
    protected String numeroSerie;
    protected int stock;

    public Producto(String nombre, double precio, String fechaImportacion, String numeroSerie, int stock) {
        this.id = siguienteId++;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.numeroSerie = numeroSerie;
        this.stock = stock;
    }

    public void agregarStock(int cantidad) {
        stock += cantidad;
        System.out.println(cantidad + " unidades de " + nombre + " agregadas al stock. Stock total: " + stock);
    }

    public void eliminarStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            System.out.println(cantidad + " unidades de " + nombre + " eliminadas del stock. Stock total: " + stock);
        } else {
            System.out.println("No hay suficientes unidades de " + nombre + " en el stock.");
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFechaImportacion() {
        return fechaImportacion;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
