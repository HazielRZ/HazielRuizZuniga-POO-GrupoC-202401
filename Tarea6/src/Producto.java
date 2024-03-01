public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor
    public Producto(String nombre, double precio) {
        this(nombre, precio, 0);
    }

    // aumentar stock
    public void aumentarStock(int cantidad) {
        if (cantidad > 0) {
            stock += cantidad;
        } else {
            System.out.println("La cantidad a aumentar debe ser mayor que 0.");
        }
    }

    // reducir stock
    public void reducirStock(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            stock -= cantidad;
        } else {
            System.out.println("La cantidad a reducir debe ser mayor que 0 y menor o igual al stock actual.");
        }
    }

    // Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null) {
            this.nombre = nombre;
        } else {
            System.out.println("El nombre no puede ser nulo.");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio no puede ser negativo.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("El stock no puede ser negativo.");
        }
    }
}