package Tarea3;
import java.lang.*;
public class Rectangulo {double ancho;
    double altura;

    // Constructor
    public Rectangulo(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    // Método para calcular el área del rectángulo
    public double calcularArea() {
        return ancho * altura;
    }

    // Método para calcular el perímetro del rectángulo
    public double calcularPerimetro() {
        return 2 * (ancho + altura);
    }

    // Método para mostrar los resultados de los cálculos
    public void mostrarResultados() {
        System.out.println("Área del rectángulo: " + calcularArea());
        System.out.println("Perímetro del rectángulo: " + calcularPerimetro());
    }
}
