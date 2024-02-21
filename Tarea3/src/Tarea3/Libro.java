package Tarea3;
import java.lang.*;
public class Libro {
    String titulo;
    java.lang.String author;
    int anoPublicacion;
    public Libro() {
        titulo = "El Señor de los Anillos";
        author = "J.R.R. Tolkien";
        anoPublicacion = 1954;
    }

    // Método para mostrar los atributos
    public void mostrarDatos() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + author);
        System.out.println("Año de Publicación: " + anoPublicacion);
    }
}

