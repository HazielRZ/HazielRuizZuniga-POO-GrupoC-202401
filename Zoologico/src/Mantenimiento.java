import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class Mantenimiento {
    private Empleado empleadoEncargado;
    private int idAnimal;
    private String procesoRealizado;
    private Date fechaProceso;
    private String observaciones;

    private static Scanner scanner = new Scanner(System.in);

    // Método para registrar un nuevo mantenimiento
    public static Mantenimiento registrarMantenimiento() {
        Mantenimiento mantenimiento = new Mantenimiento();
        System.out.println("Registrando nuevo mantenimiento:");

        System.out.print("ID del animal: ");
        mantenimiento.setIdAnimal(scanner.nextInt());
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Proceso realizado: ");
        mantenimiento.setProcesoRealizado(scanner.nextLine());

        System.out.print("Fecha del proceso (dd/mm/yyyy): ");
        mantenimiento.setFechaProceso(leerFecha());

        System.out.print("Observaciones: ");
        mantenimiento.setObservaciones(scanner.nextLine());

        return mantenimiento;
    }
    public static void consultarMantenimiento(Mantenimiento mantenimiento) {
        if (mantenimiento != null) {
            System.out.println("ID del animal: " + mantenimiento.getIdAnimal());
            System.out.println("Proceso realizado: " + mantenimiento.getProcesoRealizado());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Fecha del proceso: " + dateFormat.format(mantenimiento.getFechaProceso()));
            System.out.println("Observaciones: " + mantenimiento.getObservaciones());
        } else {
            System.out.println("El mantenimiento no existe.");
        }
    }

    // Método para leer una fecha
    private static Date leerFecha() {
        Date fecha = null;
        String inputFecha = scanner.nextLine();

        try {
            fecha = new SimpleDateFormat("dd/MM/yyyy").parse(inputFecha);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Inténtelo de nuevo.");
            fecha = leerFecha(); // Llamada recursiva para volver a solicitar la fecha
        }

        return fecha;
    }

    // Getters y setters
    public Empleado getEmpleadoEncargado() {
        return empleadoEncargado;
    }

    public void setEmpleadoEncargado(Empleado empleadoEncargado) {
        this.empleadoEncargado = empleadoEncargado;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getProcesoRealizado() {
        return procesoRealizado;
    }

    public void setProcesoRealizado(String procesoRealizado) {
        this.procesoRealizado = procesoRealizado;
    }

    public Date getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
