import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    private final List<Producto> baseDeDatosProductos;

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
        System.out.println("Producto no encontrado.");
    }

    // Método para eliminar un producto
    public void eliminarProducto(String nombreProducto) {
        baseDeDatosProductos.removeIf(producto -> producto.getNombre().equals(nombreProducto));
        guardarProductosEnArchivo();
    }

    // Método privado para guardar los productos en un archivo
    private void guardarProductosEnArchivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("productos.txt"))) {
            for (Producto producto : baseDeDatosProductos) {
                writer.println(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCantidad());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método privado para cargar los productos desde un archivo
    private List<Producto> cargarProductosDesdeArchivo() {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("productos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String nombre = parts[0];
                    double precio = Double.parseDouble(parts[1]);
                    int cantidad = Integer.parseInt(parts[2]);
                    productos.add(new Producto(nombre, precio, cantidad));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}

