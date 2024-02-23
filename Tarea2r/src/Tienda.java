import java.util.List;
import java.util.Scanner;

public class Tienda {
private final GestorProductos gestorProductos;
    private double montoTotal;

    // Constructor de Tienda
    public Tienda() {
        gestorProductos = new GestorProductos();
        montoTotal = 0.0;
    }

    // Método principal para ejecutar la tienda
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        tienda.ejecutar();
    }

    // Método para ejecutar las acciones de la tienda
    public void ejecutar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Realizar transacción");
            System.out.println("2. Crear producto");
            System.out.println("3. Editar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar productos");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    realizarTransaccion(scanner);
                    break;
                case 2:
                    crearProducto(scanner);
                    break;
                case 3:
                    editarProducto(scanner);
                    break;
                case 4:
                    eliminarProducto(scanner);
                    break;
                case 5:
                    mostrarProductos();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    // Método para realizar una transacción de compra
    private void realizarTransaccion(Scanner scanner) {
        List<Producto> productos = gestorProductos.getProductos();

        int opcionProducto;
        Producto productoSeleccionado;

        for (opcionProducto = 0; opcionProducto < productos.size(); ++opcionProducto) {
            productoSeleccionado = productos.get(opcionProducto);
            System.out.println(opcionProducto + 1 + ". " + productoSeleccionado.getNombre() + " - Precio: " + productoSeleccionado.getPrecio());
        }

        System.out.println("Ingrese el número del producto a comprar (0 para finalizar):");

        for (opcionProducto = scanner.nextInt(); opcionProducto != 0; opcionProducto = scanner.nextInt()) {
            if (opcionProducto >= 1 && opcionProducto <= productos.size()) {
                productoSeleccionado = productos.get(opcionProducto - 1);
                montoTotal += productoSeleccionado.getPrecio();
                System.out.println(productoSeleccionado.getNombre() + " añadido al carrito.");
            } else {
                System.out.println("Opción no válida.");
            }

            System.out.println("Ingrese el número del producto a comprar (0 para finalizar):");
        }

        System.out.println("Monto total a pagar: " + montoTotal);
    }

    // Método para crear un nuevo producto
    private void crearProducto(Scanner scanner) {
        System.out.println("Nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Precio del producto:");
        double precio = scanner.nextDouble();
        System.out.println("Cantidad en existencia:");
        int cantidad = scanner.nextInt();
        gestorProductos.agregarProducto(new Producto(nombre, precio, cantidad));
    }

    // Método para editar un producto existente
    private void editarProducto(Scanner scanner) {
        System.out.println("Ingrese el nombre del producto a editar:");
        String productoAEditar = scanner.nextLine();
        System.out.println("Nuevo precio:");
        double nuevoPrecio = scanner.nextDouble();
        System.out.println("Nueva cantidad en existencia:");
        int nuevaCantidad = scanner.nextInt();
        gestorProductos.editarProducto(productoAEditar, nuevoPrecio, nuevaCantidad);
    }

    // Método para eliminar un producto
    private void eliminarProducto(Scanner scanner) {
        System.out.println("Ingrese el nombre del producto a eliminar:");
        String productoAEliminar = scanner.nextLine();
        gestorProductos.eliminarProducto(productoAEliminar);
    }

    // Método para mostrar todos los productos
    private void mostrarProductos() {
        List<Producto> productos = gestorProductos.getProductos();
        System.out.println("Productos en la base de datos:");
        for (Producto producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad en existencia: " + producto.getCantidad());
            System.out.println("--------------");
        }
    }
}
