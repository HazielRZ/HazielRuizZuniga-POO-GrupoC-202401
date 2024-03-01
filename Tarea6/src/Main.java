public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Papitas", 15.99);
        System.out.println("Nombre: " + producto1.getNombre());
        System.out.println("Precio: " + producto1.getPrecio());
        System.out.println("Stock: " + producto1.getStock());

        producto1.aumentarStock(15);
        System.out.println("Stock: " + producto1.getStock());

        producto1.reducirStock(1);
        System.out.println("Stock: " + producto1.getStock());

        producto1.setNombre(null);
        producto1.setPrecio(-5.0);
        producto1.setStock(-10);
    }
}