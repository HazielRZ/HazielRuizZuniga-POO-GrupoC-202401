import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Zoologico {
    private static int idEmpleado = 1;
    private static int ultimoIdVisitante = 0;
    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Visitante> visitantes = new ArrayList<>();
    private static List<Animal> animales = new ArrayList<>();
    private static List<Visita> visitas = new ArrayList<>();
    private static List<Mantenimiento> mantenimientos = new ArrayList<>();

    private static final String CONTRASENA = "contrasena123";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bienvenido al Sistema del Zoológico de Morelia");
        validarAcceso();
    }

    private static void validarAcceso() {
        System.out.print("Ingrese la contraseña: ");
        String input = scanner.nextLine();

        if (input.equals(CONTRASENA)) {
            System.out.println("Contraseña correcta. Acceso concedido.");
            mostrarMenu();
        } else {
            System.out.println("Contraseña incorrecta. Acceso denegado.");
        }
    }


    private static void mostrarMenu() {
        int opcion;
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Modificar empleado");
            System.out.println("3. Eliminar empleado");
            System.out.println("4. Consultar empleado");
            System.out.println("5. Registrar visitante");
            System.out.println("6. Modificar visitante");
            System.out.println("7. Eliminar visitante");
            System.out.println("8. Consultar visitante");
            System.out.println("9. Registrar animal");
            System.out.println("10. Registrar visita");
            System.out.println("11. Registrar mantenimiento");
            System.out.println("12. Consultar mantenimiento");
            System.out.println("13. Consultar lista de Animales");
            System.out.println("14. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;
                case 2:
                    modificarEmpleado();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    consultarEmpleado();
                    break;
                case 5:
                    registrarVisitante();
                    break;
                case 6:
                    modificarVisitante();
                    break;
                case 7:
                    eliminarVisitante();
                    break;
                case 8:
                    consultarVisitante();
                    break;
                case 9:
                    registrarAnimal();
                    break;
                case 10:
                    registrarVisita();
                    break;
                case 11:
                    registrarMantenimiento();
                    break;
                case 12:
                    consultarMantenimiento();
                    break;
                case 14:
                    salir = true;
                    break;
                case 13:
                    consultarAnimales();
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    private static void registrarEmpleado() {
        System.out.println("Registrando nuevo empleado:");
        int id = IdGenerator.generarIdEmpleado();
        // Solicitar información del empleado
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        Date fechaNacimiento = leerFecha("Fecha de nacimiento (dd/MM/yyyy): ");
        Date fechaIngreso = leerFecha("Fecha de ingreso (dd/MM/yyyy): ");
        System.out.print("RFC: ");
        String rfc = scanner.nextLine();
        System.out.print("CURP: ");
        String curp = scanner.nextLine();
        System.out.print("Salario: ");
        double salario = Double.parseDouble(scanner.nextLine());
        System.out.print("Horario: ");
        String horario = scanner.nextLine();
        System.out.print("Rol: ");
        String rol = scanner.nextLine();

        // Crear una nueva instancia de Empleado
        Empleado empleado = new Empleado(id,nombre, apellidos, fechaNacimiento, fechaIngreso,
                rfc, curp, salario, horario, rol);

        // Asignar un ID único al empleado
        empleado.setId(idEmpleado++);

        // Agregar el empleado a la lista de empleados del zoológico
        empleados.add(empleado);

        System.out.println("Empleado registrado con éxito.");
    }
    private static Date leerFecha(String mensaje) {
        Date fecha = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        do {
            System.out.print(mensaje);
            String inputFecha = scanner.nextLine();

            try {
                fecha = dateFormat.parse(inputFecha);
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Inténtelo de nuevo.");
            }
        } while (fecha == null);

        return fecha;
    }
    private static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null; // Si no se encuentra el empleado con el ID dado
    }


    private static void modificarEmpleado() {
        System.out.println("Modificando empleado:");

        // Solicitar identificación del empleado a modificar
        System.out.print("Ingrese el ID del empleado a modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Buscar el empleado en la lista de empleados
        Empleado empleado = buscarEmpleadoPorId(id);
        if (empleado != null) {
            // Lógica para modificar los datos del empleado
            // Por ejemplo, puedes solicitar al usuario que ingrese los nuevos valores y modificar el objeto empleado correspondiente
            System.out.println("Ingrese los nuevos datos del empleado:");

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            empleado.setNombre(nombre);

            System.out.print("Nuevos apellidos: ");
            String apellidos = scanner.nextLine();
            empleado.setApellidos(apellidos);

            // Continuar con la solicitud de la información del empleado y modificar los atributos según sea necesario

            System.out.println("Empleado modificado con éxito.");
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }


        private static void eliminarEmpleado () {
            System.out.print("Ingrese el ID del empleado a eliminar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Empleado empleado = buscarEmpleadoPorId(id);
            if (empleado != null) {
                empleados.remove(empleado); // Eliminar el empleado de la lista
                System.out.println("Empleado eliminado con éxito.");
            } else {
                System.out.println("Empleado no encontrado.");
            }
        }

        private static void consultarEmpleado () {
            System.out.print("Ingrese el ID del empleado a consultar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Empleado empleado = buscarEmpleadoPorId(id);
            if (empleado != null) {
                System.out.println(empleado); // Mostrar los detalles del empleado
            } else {
                System.out.println("Empleado no encontrado.");
            }
        }

    private static void registrarVisitante() {
        System.out.println("Registrando nuevo visitante:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();

        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("CURP: ");
        String curp = scanner.nextLine();

        System.out.print("Número de visitas: ");
        int numeroVisitas = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        // Se genera el nuevo ID de visitante
        int nuevoId = ++ultimoIdVisitante;

        // Se crea y agrega el nuevo visitante a la lista
        Visitante nuevoVisitante = new Visitante(nuevoId, nombre, apellidos, fechaNacimiento, curp, numeroVisitas, obtenerFechaActual());
        visitantes.add(nuevoVisitante);

        System.out.println("Visitante registrado con éxito.");
    }

    private static void modificarVisitante() {
        System.out.print("Ingrese el ID del visitante que desea modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Visitante visitante = buscarVisitantePorId(id);
        if (visitante != null) {
            System.out.println("Modificando visitante:");
            // Se solicitan y actualizan los datos del visitante
            System.out.print("Nuevo nombre: ");
            visitante.setNombre(scanner.nextLine());

            System.out.print("Nuevos apellidos: ");
            visitante.setApellidos(scanner.nextLine());

            System.out.print("Nueva fecha de nacimiento (dd/mm/yyyy): ");
            visitante.setFechaNacimiento(scanner.nextLine());

            System.out.print("Nuevo CURP: ");
            visitante.setCurp(scanner.nextLine());

            System.out.print("Nuevo número de visitas: ");
            visitante.setNumeroVisitas(scanner.nextInt());
            scanner.nextLine(); // Consumir la nueva línea

            System.out.println("Visitante modificado con éxito.");
        } else {
            System.out.println("No se encontró ningún visitante con ese ID.");
        }
    }

    private static void eliminarVisitante() {
        System.out.print("Ingrese el ID del visitante que desea eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Visitante visitante = buscarVisitantePorId(id);
        if (visitante != null) {
            visitantes.remove(visitante);
            System.out.println("Visitante eliminado con éxito.");
        } else {
            System.out.println("No se encontró ningún visitante con ese ID.");
        }
    }

    private static void consultarVisitante() {
        System.out.print("Ingrese el ID del visitante que desea consultar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        Visitante visitante = buscarVisitantePorId(id);
        if (visitante != null) {
            System.out.println("Datos del visitante:");
            System.out.println("ID: " + visitante.getId());
            System.out.println("Nombre: " + visitante.getNombre());
            System.out.println("Apellidos: " + visitante.getApellidos());
            System.out.println("Fecha de nacimiento: " + visitante.getFechaNacimiento());
            System.out.println("CURP: " + visitante.getCurp());
            System.out.println("Número de visitas: " + visitante.getNumeroVisitas());
            System.out.println("Fecha de registro: " + visitante.getFechaRegistro());
        } else {
            System.out.println("No se encontró ningún visitante con ese ID.");
        }
    }

    // Método auxiliar para buscar un visitante por su ID
    private static Visitante buscarVisitantePorId(int id) {
        for (Visitante visitante : visitantes) {
            if (visitante.getId() == id) {
                return visitante;
            }
        }
        return null;
    }

    // Método auxiliar para obtener la fecha actual en formato dd/mm/yyyy
    private static String obtenerFechaActual() {
        java.util.Date fechaActual = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaActual);
    }


    private static void registrarAnimal () {
            Animal animal = Animal.registrarAnimal();
            // Agregar el animal a la lista de animales
            animales.add(animal);
            System.out.println("Animal registrado con éxito.");
        }

        private static Visita registrarVisita () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Registrando nueva visita:");

            System.out.print("Nombre del guía a cargo: ");
            String nombreGuia = scanner.nextLine();
            // Aquí deberías buscar al empleado por su nombre o algún otro identificador y asignarlo como guía

            System.out.print("Costo total de la visita: ");
            double costoTotal = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Fecha de la visita (dd/mm/yyyy): ");
            String fechaVisita = scanner.nextLine();

            System.out.print("Cantidad de niños: ");
            int cantidadNinos = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            System.out.print("Cantidad de adultos: ");
            int cantidadAdultos = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            // Crear y retornar una nueva instancia de Visita
            return new Visita(new Empleado(nombreGuia), costoTotal, fechaVisita, cantidadNinos, cantidadAdultos);
        }

        private static void registrarMantenimiento () {
            Mantenimiento mantenimiento = Mantenimiento.registrarMantenimiento();
            mantenimientos.add(mantenimiento);
            System.out.println("Mantenimiento registrado con éxito.");
        }

        private static void consultarMantenimiento () {
            System.out.print("ID del mantenimiento a consultar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            Mantenimiento mantenimiento = buscarMantenimientoPorId(id);
            Mantenimiento.consultarMantenimiento(mantenimiento);
        }

        private static Mantenimiento buscarMantenimientoPorId ( int id){
            for (Mantenimiento mantenimiento : mantenimientos) {
                if (mantenimiento.getIdAnimal() == id) {
                    return mantenimiento;
                }
            }
            return null;
        }
        private static void consultarAnimales () {
            System.out.println("\nLista de Animales:");
            if (animales.isEmpty()) {
                System.out.println("No hay animales registrados.");
            } else {
                for (int i = 0; i < animales.size(); i++) {
                    Animal animal = animales.get(i);
                    System.out.println("Animal " + (i + 1) + ":");
                    System.out.println("Tipo de animal: " + animal.getTipoAnimal());
                    System.out.println("Fecha de nacimiento: " + animal.getFechaNacimiento());
                    System.out.println("Peso: " + animal.getPeso());

                    System.out.println();
                }
            }
        }
    }
