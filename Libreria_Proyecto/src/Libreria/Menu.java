package Libreria;

import Usuarios.Cliente;
import Usuarios.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

import utils.UsuarioEnSesion;

public class Menu {

    Scanner leer = new Scanner(System.in);
    private Libreria newLibreria = new Libreria();

    public Menu(Libreria libreria) {
        this.newLibreria = libreria;
    }


    public void iniciarSesion() //Se puede  hace estático para no crear un objeto de programa en el main
    {
        Scanner leer = new Scanner(System.in);
        boolean datosCorrectos = false;
        do {
            System.out.println("\n\t***BIENVENIDO AL SISTEMA BIBLIOTECA***");
            System.out.println("\nPara continuar inicia sesión");

            System.out.print("\nIngresa tu usuario: ");
            String Usuario = leer.nextLine();

            System.out.print("Ingresa tu contraseña: ");
            String contrasena = leer.nextLine();

            Usuario usuarioActual = newLibreria.verificarInicioSesion(Usuario, contrasena);
            if (usuarioActual != null) {
                //Datos correctos y mostramos menú correspondiente
                datosCorrectos = true;

                UsuarioEnSesion.obtenerInstancia().setUsuarioActual(usuarioActual);
                seleccionarMenu();

            } else {
                //Datos incorrectos
                System.out.println("\nUsuario o contraseña incorrectos, intenta de nuevo");
            }
        } while (!datosCorrectos);
    }

    private void seleccionarMenu() {
        Usuario usuario = UsuarioEnSesion.obtenerInstancia().getUsuarioActual();

        switch (usuario.getRol()) {
            // -> Función lambda
            case CLIENTE -> mostrarMenuCliente();
            case ASISTENTE -> mostrarMenuAsistente();
            case GERENTE -> mostrarMenuGerente();

        }
    }

    //Menus de cada usuario
    private void mostrarMenuCliente() {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n***Menú de cliente***");
            System.out.println("1) Consultar libros: ");
            System.out.println("2) Consultar mis rentas: ");
            System.out.println("3) Mostrar mis datos");
            System.out.println("4) Editar mi información");
            System.out.println("5) Cerrar sesión");

            System.out.print("\nSeleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    newLibreria.consultarLibros();
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    break;

                case 5:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    this.iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 5);

    }

    private void mostrarMenuAsistente() {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n***Menú de asistente***");

            System.out.println("\n1) Registrar libros");
            System.out.println("2) Registrar clientes");
            System.out.println("3) Registrar asistente");
            System.out.println("4) Consultar libros");
            System.out.println("5) Consultar clientes");
            System.out.println("6) Consultar asistentes");
            System.out.println("7) Modificar libro");
            System.out.println("8) Modificar cliente");
            System.out.println("9) Modificar asistente");
            System.out.println("10) Eliminar libro");
            System.out.println("11) Eliminar cliente");
            System.out.println("12) Eliminar asistente");
            System.out.println("13) Realizar renta");
            System.out.println("14) Consultar rentas");
            System.out.println("15) Cerrar sesión");

            System.out.print("\nSeleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    newLibreria.registrarLibro();
                    break;

                case 2:
                    // Lógica para registrar clientes
                    newLibreria.registrarCliente();
                    break;

                case 3:
                    // Lógica para registrar asistentes
                    newLibreria.registrarAsistente();
                    break;

                case 4:
                    newLibreria.consultarLibros();
                    break;

                case 5:
                    // Lógica para consultar clientes
                    newLibreria.mostrarClientes();
                    break;

                case 6:
                    // Lógica para consultar asistentes
                    newLibreria.mostrarAsistentes();
                    break;

                case 7:
                    // Lógica para modificar libro
                    break;

                case 8:
                    // Lógica para modificar cliente
                    break;

                case 9:
                    // Lógica para modificar asistente
                    break;

                case 10:
                    // Lógica para eliminar libro
                    break;

                case 11:
                    // Lógica para eliminar cliente
                    break;

                case 12:
                    // Lógica para eliminar asistente
                    break;

                case 13:
                    // Lógica para realizar renta
                    break;

                case 14:
                    // Lógica para consultar rentas
                    break;

                case 15:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    this.iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 15);

    }

    private void mostrarMenuGerente() {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n***Menú de gerente***");

            System.out.println("\n1) Registrar libros");
            System.out.println("2) Registrar clientes");
            System.out.println("3) Registrar asistente");
            System.out.println("4) Consultar libros");
            System.out.println("5) Consultar clientes");
            System.out.println("6) Consultar asistentes");
            System.out.println("7) Modificar libro");
            System.out.println("8) Modificar cliente");
            System.out.println("9) Modificar asistente");
            System.out.println("10) Eliminar libro");
            System.out.println("11) Eliminar cliente");
            System.out.println("12) Eliminar asistente");
            System.out.println("13) Realizar renta");
            System.out.println("14) Consultar rentas");
            System.out.println("15) Cerrar sesión");

            System.out.print("\nSeleccione una opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    newLibreria.registrarLibro();
                    break;

                case 2:
                    // Lógica para registrar clientes
                    newLibreria.registrarCliente();
                    break;

                case 3:
                    // Lógica para registrar asistentes
                    newLibreria.registrarAsistente();
                    break;

                case 4:
                    newLibreria.consultarLibros();
                    break;

                case 5:
                    // Lógica para consultar clientes
                    newLibreria.mostrarClientes();
                    break;

                case 6:
                    // Lógica para consultar asistentes
                    newLibreria.mostrarAsistentes();
                    break;

                case 7:
                    // Lógica para modificar libro
                    break;

                case 8:
                    // Lógica para modificar cliente
                    break;

                case 9:
                    // Lógica para modificar asistente
                    break;

                case 10:
                    // Lógica para eliminar libro
                    break;

                case 11:
                    // Lógica para eliminar cliente
                    break;

                case 12:
                    // Lógica para eliminar asistente
                    break;

                case 13:
                    // Lógica para realizar renta
                    break;

                case 14:
                    // Lógica para consultar rentas
                    break;

                case 15:
                    System.out.println("\nCerrando sesión");
                    UsuarioEnSesion.obtenerInstancia().cerrarSesion();
                    this.iniciarSesion();
                    break;

                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 15);
    }
}