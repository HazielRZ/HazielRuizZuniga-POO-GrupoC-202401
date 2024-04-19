package Libreria;

import Usuarios.Asistente;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.Utils.Rol;

import java.util.ArrayList;
import java.util.Scanner;

import utils.UsuarioEnSesion;

public class Libreria {

    Scanner leer = new Scanner(System.in);
    private final ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private final ArrayList<Libro> listaLibros = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    // @SuppressWarnings("rawTypes") especifica que advertencias queremos que ignore


    public Libreria() {

        Asistente asistente = new Asistente(1500, "Juan", "Rivera", "5454567", "GAJOSJOE", "Juan123", "12345");
        listaUsuarios.add(asistente);

    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        return listaUsuarios.stream()
                .filter(usuario -> usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario) && usuario.getContrasena().equals(contrasena))
                .findFirst()
                .orElse(null);
    }

    //********libros*******
    public void registrarLibro() {
        System.out.println("\n***Registro de libro***");

        System.out.print("Título del libro: ");
        String titulo = scanner.nextLine();

        System.out.print("Autor del libro: ");
        String autor = scanner.nextLine();

        System.out.print("Género del libro: ");
        String genero = scanner.nextLine();

        System.out.print("Año de publicación del libro: ");
        int añoPublicacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        Libro libro = new Libro(titulo, autor, genero, añoPublicacion);
        listaLibros.add(libro);

        System.out.println("Libro registrado con éxito.");
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("\n***Libros disponibles***");
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros disponibles en este momento.");
        } else {
            for (Libro libro : listaLibros) {
                if (libro.isDisponible()) {
                    System.out.println(libro);
                }
            }
        }
    }


    public void consultarLibros() {
        if (listaLibros.isEmpty()) {
            System.out.println("\nNo hay libros registrados en la librería.");
        } else {
            System.out.println("\n***Lista de Libros***");
            for (Libro libro : listaLibros) {
                System.out.println(libro);
            }
        }
    }

    public void prestarLibro() {
        if (listaLibros.isEmpty()) {
            System.out.println("\nNo hay libros disponibles para prestar.");
            return;
        }

        System.out.print("\nIngrese el título del libro a prestar: ");
        String titulo = leer.nextLine();

        Libro libroEncontrado = null;
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado != null) {
            if (libroEncontrado.getCantidadCopias() > 0) {
                libroEncontrado.prestar();
                System.out.println("Se ha prestado el libro \"" + libroEncontrado.getTitulo() + "\".");
            } else {
                System.out.println("No hay copias disponibles del libro \"" + libroEncontrado.getTitulo() + "\".");
            }
        } else {
            System.out.println("El libro \"" + titulo + "\" no se encuentra registrado en la librería.");
        }
    }

    public void devolverLibro() {
        if (listaLibros.isEmpty()) {
            System.out.println("\nNo hay libros prestados.");
            return;
        }

        System.out.print("\nIngrese el título del libro a devolver: ");
        String titulo = leer.nextLine();

        Libro libroEncontrado = null;
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado != null) {
            libroEncontrado.devolver();
            System.out.println("Se ha devuelto el libro \"" + libroEncontrado.getTitulo() + "\".");
        } else {
            System.out.println("El libro \"" + titulo + "\" no se encuentra registrado en la librería.");
        }
    }


    //******************************************Registros****************************************************
    public void registrarCliente() {

        System.out.println("\n***Registro de cliente***");

        System.out.print("\nIngresa tu nombre: ");
        String nombre = leer.nextLine();

        System.out.print("Ingresa tu apellido: ");
        String apellido = leer.nextLine();

        String telefono = registrarTelefonoUsuario();
        String nombreUsuario = registrarNombreUsuario();

        System.out.print("Contraseña: ");
        String clave = leer.nextLine();

        Cliente newCliente = new Cliente(nombre, apellido, telefono, nombreUsuario, clave);
        listaUsuarios.add(newCliente);

        System.out.println("Usuario registrado con rol de CLIENTE y con id " + newCliente.getId());
    }

    public void registrarAsistente() {

        Rol rol = UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n***Registro de asistente***");

            System.out.print("\nIngresa el nombre: ");
            String nombre = leer.nextLine();

            System.out.print("Ingresa el apellido: ");
            String apellido = leer.nextLine();

            System.out.print("Ingresa el sueldo: ");
            double sueldo = leer.nextDouble();

            System.out.print("Ingresa el RFC: ");
            String RFC = leer.nextLine();

            String telefono = registrarTelefonoUsuario();
            String nombreUsuario = registrarNombreUsuario();

            System.out.print("Contraseña: ");
            String clave = leer.nextLine();

            Asistente newAsistente = new Asistente(sueldo, RFC, nombre, apellido, telefono, nombreUsuario, clave);
            listaUsuarios.add(newAsistente);

            System.out.println("Usuario registrado con rol de ASISTENTE y con id " + newAsistente.getId());
        } else {
            System.out.println("\nNo eres un gerente, no puedes registrar a un asistente");
        }

    }

    public void registrarGerente() {
        Rol rol = UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n***Registro de gerente**");

            System.out.print("\nIngresa el nombre: ");
            String nombre = leer.nextLine();

            System.out.print("Ingresa el apellido: ");
            String apellido = leer.nextLine();

            System.out.print("Ingresa el sueldo: ");
            double sueldo = leer.nextDouble();

            System.out.print("Ingresa la INE: ");
            String INE = leer.nextLine();

            String telefono = registrarTelefonoUsuario();
            String nombreUsuario = registrarNombreUsuario();

            System.out.print("Contraseña: ");
            String clave = leer.nextLine();

            Gerente newGerente = new Gerente(sueldo, INE, nombre, apellido, telefono, nombreUsuario, clave);
            listaUsuarios.add(newGerente);

            System.out.println("Usuario registrado con rol de GERENTE y con id " + newGerente.getId());
        } else {
            System.out.println("\nNo eres un gerente, no puedes registrar a otro gerente");
        }

    }

    //*******Validamos que  telefono y nombre de usuario no se repitan******
    private String registrarTelefonoUsuario() {
        boolean telefonoExistente = true;

        //Scope: entre que rango existe una variable
        String telefono = "";
        do {
            System.out.print("Ingresa tu teléfono: ");
            telefono = leer.nextLine();

            telefonoExistente = false;
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getTelefono().equals(telefono)) {
                    telefonoExistente = true;
                    break;
                }
            }

            if (telefonoExistente) {
                System.out.println("\nEl teléfono ya se encuentra registrado. Intenta de nuevo");
            }
        } while (telefonoExistente);

        return telefono;
    }

    private String registrarNombreUsuario() {
        boolean nombreUsuarioExistente = true;

        String nombreUsuario = "";
        do {
            System.out.print("Nombre de usuario: ");
            nombreUsuario = leer.nextLine();

            nombreUsuarioExistente = false;
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getTelefono().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                    break;
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("\nYa existe un registro con ese nombre de usuario. Intenta de nuevo");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

    //****************************************Mostrar Listas********************************
    public void mostrarClientes() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("\nNo hay cliente registrados");
        } else {
            System.out.println("\n**Lista de Clientes**");

            for (Usuario usuario : listaUsuarios) {
                if (usuario.getRol() == Rol.CLIENTE) {
                    //Convertir de usuario a cliente (parseo)
                    Cliente cliente = (Cliente) usuario;
                    System.out.println(cliente);
                }
            }
        }
    }

    public void mostrarAsistentes() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("\nNo hay asistentes registrados");
        } else {
            System.out.println("\n**Lista de Asistentes**");
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getRol() == Rol.ASISTENTE) {
                    //Convertir de usuario a asistente (parseo)
                    Asistente asistente = (Asistente) usuario;
                    System.out.println(asistente);
                }
            }
        }
    }

    public void mostrarGerentes() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("\nNo hay gerentes registrados");
        } else {
            System.out.println("\n**Lista de Gerentes**");
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getRol() == Rol.GERENTE) {
                    //Convertir de usuario a asistente (parseo)
                    Gerente gerente = (Gerente) usuario;
                    System.out.println(gerente);
                }
            }
        }
    }

    //******************************************Eliminación********************************************
    public void eliminarClientes() {
        Scanner leer = new Scanner(System.in);

        System.out.println("\n**Eliminación de clientes");

        System.out.print("\nIngrese el nombre de usuario del cliente a eliminar: ");
        String nombreUsuario = leer.nextLine();

        int indiceEliminado = 0;

        for (Usuario cliente : listaUsuarios) {
            if (cliente.getNombreUsuario().equals(nombreUsuario)) {
                listaUsuarios.remove(indiceEliminado);
                System.out.println("\nCliente eliminado con éxito");
                return;
            }
            indiceEliminado++;
        }
        System.out.println("\nEl cliente no existe en sistema");

    }

    public void eliminarAsistente() {
        Scanner leer = new Scanner(System.in);

        Rol rol = UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n**Eliminación de asistente");

            System.out.print("\nIngrese el nombre de usuario del asistente a eliminar: ");
            String nombreUsuario = leer.nextLine();

            int indiceEliminado = 0;

            for (Usuario asistente : listaUsuarios) {
                if (asistente.getNombreUsuario().equals(nombreUsuario)) {
                    listaUsuarios.remove(indiceEliminado);
                    System.out.println("\nAsistente eliminado con éxito");
                    return;
                }
                indiceEliminado++;
            }
            System.out.println("\nEl asistente no existe en sistema");

        } else {
            System.out.println("\nNo eres un gerente no puede eliminar un asistente");
        }

    }

    public void eliminarGerente() {
        Scanner leer = new Scanner(System.in);

        Rol rol = UsuarioEnSesion.obtenerInstancia().getUsuarioActual().getRol();

        if (rol == Rol.GERENTE) {
            System.out.println("\n**Eliminación de gerente");

            System.out.print("\nIngrese el nombre de usuario del gerente a eliminar: ");
            String nombreUsuario = leer.nextLine();

            int indiceEliminado = 0;

            for (Usuario gerente : listaUsuarios) {
                if (gerente.getNombreUsuario().equals(nombreUsuario)) {
                    listaUsuarios.remove(indiceEliminado);
                    System.out.println("\nGerente eliminado con éxito");
                    return;
                }
                indiceEliminado++;
            }
            System.out.println("\nEl gerente no existe en sistema");

        } else {
            System.out.println("\nNo eres un gerente, no puedes eliminar a otro gerente");
        }

    }

    public void registrarCliente(Cliente cliente) {
        listaUsuarios.add(cliente);
    }

    public void registrarAsistente(Asistente asistente) {
        listaUsuarios.add(asistente);
    }

    public void registrarGerente(Gerente gerente) {
        listaUsuarios.add(gerente);
    }


}