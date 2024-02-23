public class Producto {
    private final String nombre;
    private double precio;
    private int cantidad;

    // Constructor de Producto
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Métodos para acceder a los atributos del producto
    public String getNombre() {
        return this.nombre;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    // Métodos para modificar los atributos del producto
    public void setPrecio(double nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public void setCantidad(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }
}



