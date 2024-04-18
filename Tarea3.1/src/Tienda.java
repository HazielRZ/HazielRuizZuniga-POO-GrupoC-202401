import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Tienda {
    private static final String PASSWORD = "contraseña";
    private final Map<Integer, Producto> inventario = new HashMap<>();
    private final List<Producto> ventas = new ArrayList<>();
    private final List<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public boolean verificarPassword(String password) {
        return password.equals(PASSWORD);
    }

    public void agregarProducto(Producto producto) {
        inventario.put(producto.getId(), producto);
    }

    public void eliminarProducto(int id) {
        if (!ventas.isEmpty() && ventas.stream().anyMatch(p -> p.getId() == id)) {
            System.out.println("No se puede eliminar el producto porque tiene ventas asociadas.");
            return;
        }
        inventario.remove(id);
        System.out.println("Producto eliminado correctamente.");
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(int id) {
        if (!ventas.isEmpty() && ventas.stream().anyMatch(p -> p.getId() == id)) {
            System.out.println("No se puede eliminar el cliente porque tiene compras asociadas.");
            return;
        }
        clientes.removeIf(cliente -> cliente.getId() == id);
        System.out.println("Cliente eliminado correctamente.");
    }

    public void realizarVenta(Cliente cliente, Producto producto) {
        ventas.add(producto);
        System.out.println("Venta realizada: Cliente: " + cliente.getNombre() + ", Producto: " + producto.getNombre());
    }

    public void mostrarVentas() {
        System.out.println("Ventas realizadas:");
        for (Producto producto : ventas) {
            System.out.println("Producto: " + producto.getNombre());
        }
    }

    public int obtenerCantidadProductos() {
        return inventario.size();
    }

    public int obtenerCantidadClientes() {
        return clientes.size();
    }

    public void registrarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.println("Ingrese la fecha de importación del producto (formato YYYY-MM-DD):");
        String fechaImportacion = scanner.nextLine();
        System.out.println("Ingrese el número de serie del producto:");
        String numeroSerie = scanner.nextLine();
        System.out.println("Ingrese la cantidad inicial de stock del producto:");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        Producto producto = new Producto(nombre, precio, fechaImportacion, numeroSerie, stock);
        agregarProducto(producto);
        System.out.println("Producto registrado correctamente.");
    }

    public void registrarCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        Cliente cliente = new Cliente(nombre);
        agregarCliente(cliente);
        System.out.println("Cliente registrado correctamente.");
    }

    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la contraseña:");
        String password = scanner.nextLine();
        if (!tienda.verificarPassword(password)) {
            System.out.println("Contraseña incorrecta. Saliendo del programa.");
            return;
        }

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar producto");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas realizadas");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Eliminar cliente");
            System.out.println("7. Mostrar cantidad de productos y clientes");
            System.out.println("8. Salir");
            System.out.println("Ingrese una opción:");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    tienda.registrarProducto();
                    break;
                case 2:
                    tienda.registrarCliente();
                    break;
                case 3:
                    System.out.println("Ingrese el ID del cliente:");
                    int idCliente = scanner.nextInt();
                    Cliente cliente = tienda.clientes.stream().filter(c -> c.getId() == idCliente).findFirst().orElse(null);
                    if (cliente == null) {
                        System.out.println("Cliente no encontrado.");
                        break;
                    }
                    System.out.println("Lista de productos disponibles:");
                    for (Map.Entry<Integer, Producto> entry : tienda.inventario.entrySet()) {
                        Producto p = entry.getValue();
                        System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre());
                    }
                    System.out.println("Ingrese el ID del producto:");
                    int idProducto = scanner.nextInt();
                    Producto producto = tienda.inventario.get(idProducto);
                    if (producto == null) {
                        System.out.println("Producto no encontrado.");
                        break;
                    }

                    System.out.println("El precio del producto " + producto.getNombre() + " es: $" + producto.getPrecio());
                    System.out.println("¿Desea realizar la compra? (1/0)");
                    int confirmacion = scanner.nextInt();
                    if (confirmacion == 1) {
                        tienda.realizarVenta(cliente, producto);
                    } else {
                        System.out.println("Venta cancelada.");
                    }
                    break;

                case 4:
                    tienda.mostrarVentas();
                    break;
                case 5:
                    System.out.println("Ingrese el ID del producto a eliminar:");
                    int idProductoEliminar = scanner.nextInt();
                    tienda.eliminarProducto(idProductoEliminar);
                    break;
                case 6:
                    System.out.println("Ingrese el ID del cliente a eliminar:");
                    int idClienteEliminar = scanner.nextInt();
                    tienda.eliminarCliente(idClienteEliminar);
                    break;
                case 7:
                    System.out.println("Número de productos en inventario: " + tienda.obtenerCantidadProductos());
                            System.out.println("Número de clientes registrados: " + tienda.obtenerCantidadClientes());
                    break;
                case 8:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
