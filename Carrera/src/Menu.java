import Fachada.Fachada;

import java.util.Scanner;

public abstract class Menu {
    protected Fachada fachada;
    protected Scanner scanner = new Scanner(System.in);

    public Menu(Fachada fachada) {
        this.fachada = fachada;
    }

    public abstract void mostrar();

    protected int leerOpcion() {
        System.out.print("Ingrese su opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        return opcion;
    }
}