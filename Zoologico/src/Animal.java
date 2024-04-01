import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Animal {
    private final int id;
    private String tipoAnimal;
    private Date fechaNacimiento;
    private double peso;
    private final ArrayList<String> enfermedades;
    private String frecuenciaAlimentacion;
    private String tipoAlimentacion;
    private boolean vacunas;

    private static final Scanner scanner = new Scanner(System.in);
    private static int animalIdCounter = 0;

    // Constructor
    public Animal() {
        this.enfermedades = new ArrayList<>();
        this.id = ++animalIdCounter;
    }

    // Método para registrar un nuevo animal
    public static Animal registrarAnimal() {
        Animal animal = new Animal();
        System.out.println("Registrando nuevo animal:");

        System.out.print("Tipo de animal: ");
        animal.setTipoAnimal(scanner.nextLine());

        System.out.print("Fecha de nacimiento (dd/mm/yyyy): ");
        animal.setFechaNacimiento(leerFecha());

        // Solicitar y establecer el resto de los atributos del animal...
        System.out.print("Peso: ");
        animal.setPeso(Double.parseDouble(scanner.nextLine()));

        System.out.print("Frecuencia de alimentación: ");
        animal.setFrecuenciaAlimentacion(scanner.nextLine());

        System.out.print("Tipo de alimentación: ");
        animal.setTipoAlimentacion(scanner.nextLine());

        System.out.print("¿Tiene vacunas? (true/false): ");
        animal.setVacunas(Boolean.parseBoolean(scanner.nextLine()));

        return animal;
    }

    // Método para leer una fecha
    private static Date leerFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;

        String inputFecha = scanner.nextLine();

        try {
            fecha = dateFormat.parse(inputFecha);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Inténtelo de nuevo.");
        }

        return fecha;
    }




    static Date getDate(Scanner scanner, Date date) {
        Date fecha;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String inputFecha = scanner.nextLine();

        try {
            fecha = dateFormat.parse(inputFecha);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Inténtelo de nuevo.");
            fecha = date;
        }

        return fecha;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public ArrayList<String> getEnfermedades() {
        return enfermedades;
    }

    public void agregarEnfermedad(String enfermedad) {
        this.enfermedades.add(enfermedad);
    }

    public String getFrecuenciaAlimentacion() {
        return frecuenciaAlimentacion;
    }

    public void setFrecuenciaAlimentacion(String frecuenciaAlimentacion) {
        this.frecuenciaAlimentacion = frecuenciaAlimentacion;
    }

    public String getTipoAlimentacion() {
        return tipoAlimentacion;
    }

    public void setTipoAlimentacion(String tipoAlimentacion) {
        this.tipoAlimentacion = tipoAlimentacion;
    }

    public boolean isVacunas() {
        return vacunas;
    }

    public void setVacunas(boolean vacunas) {
        this.vacunas = vacunas;
    }
}