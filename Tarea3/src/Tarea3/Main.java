package Tarea3;
import java.util.Scanner;

import java.lang.*;
public class Main {
    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            int option;

            do {
                System.out.println("Menú:");
                System.out.println("1. Mostrar datos de Personas");
                System.out.println("2. Mostrar datos de Libros");
                System.out.println("3. Mostrar resultados de Rectángulos");
                System.out.println("4. Salir");
                System.out.print("Ingrese una opción: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        mostrarDatosPersonas();
                        break;
                    case 2:
                        mostrarDatosLibros();
                        break;
                    case 3:
                        mostrarResultadosRectangulos();
                        break;
                    case 4:
                        System.out.println("Saliendo del program...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                }
            } while (option != 4);
        }

        // mostrar  personas
        public static void mostrarDatosPersonas() {
            System.out.println("Datos de Personas:");
            Persona persona1 = new Persona("Haziel", 21, "Masculino");
            persona1.mostrarDatos();

            Persona persona2 = new Persona("Natalia", 30, "Femenino");
            persona2.mostrarDatos();

            Persona persona3 = new Persona("Juan", 40, "Masculino");
            persona3.mostrarDatos();

            Persona persona4 = new Persona("Beirut", 35, "Femenino");
            persona4.mostrarDatos();
        }

        // mostrar datos de libros
        public static void mostrarDatosLibros() {
            System.out.println("Datos de Libros:");
            Libro libro1 = new Libro();
            libro1.mostrarDatos();

            Libro libro2 = new Libro();
            libro2.titulo = "Fundamentos de bases de datos";
            libro2.author = "Silberschatz, Henry F. Korth, S. Sudarshan ";
            libro2.anoPublicacion = 2014;
            libro2.mostrarDatos();

            Libro libro3 = new Libro();
            libro3.titulo = "Fundamentos de Sistemas Operativos ";
            libro3.author = "Abraham Silberschatz, Peter Baer Galvin";
            libro3.anoPublicacion = 2006;
            libro3.mostrarDatos();

            Libro libro4 = new Libro();
            libro4.titulo = "PROGRAMACION EN C, C++, JAVA Y UML";
            libro4.author = "Luis Joyanes Aguilar ";
            libro4.anoPublicacion = 2013;
            libro4.mostrarDatos();
        }

        // mostrar rectángulos
        public static void mostrarResultadosRectangulos() {
            System.out.println("Resultados de Rectángulos:");
            Rectangulo rectangulo1 = new Rectangulo(2.0, 4.0);
            rectangulo1.mostrarResultados();

            Rectangulo rectangulo2 = new Rectangulo(3.0, 9.0);
            rectangulo2.mostrarResultados();

            Rectangulo rectangulo3 = new Rectangulo(6.0, 9.0);
            rectangulo3.mostrarResultados();

            Rectangulo rectangulo4 = new Rectangulo(8.0, 2.0);
            rectangulo4.mostrarResultados();
        }
    }
