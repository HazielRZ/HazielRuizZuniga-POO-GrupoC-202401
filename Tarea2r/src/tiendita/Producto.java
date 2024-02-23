
package tiendita;
import java.io.*;
import java.util.*;
import java.util.List;

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
    // Clase que gestiona los productos en la tienda
class GestorProductos {
    private List<Producto> baseDeDatosProductos;

    // Constructor de GestorProductos
    public GestorProductos() {
        baseDeDatosProductos = cargarProductosDesdeArchivo();
    }

    // Método para obtener la lista de productos
    public List<Producto> getProductos() {
        return baseDeDatosProductos;
    }

    // Método para agregar un nuevo producto
    public void agregarProducto(Producto producto) {
        baseDeDatosProductos.add(producto);
        guardarProductosEnArchivo();
    }

    // Método para editar un producto existente
    public void editarProducto(String nombreProducto, double nuevoPrecio, int nuevaCantidad) {
        for (Producto producto : baseDeDatosProductos) {
            if (producto.getNombre().equals(nombreProducto)) {
                producto.setPrecio(nuevoPrecio);
                producto.setCantidad(nuevaCantidad);
                guardarProductosEnArchivo();
                return;
            }
        }
    }
    
}

}
