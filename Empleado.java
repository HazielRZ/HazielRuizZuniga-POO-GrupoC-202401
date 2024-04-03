
package proyectoclases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Empleado {
    Scanner scanner = new Scanner(System.in);
    private String   name, apellidos;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private String RFC, curp;
    private double salario = 0;
    private String horario;
    private String rol;//mantenimiento, veterinario, guia, administracion
    
    private static int empleadoContador = 0;
    
    public Empleado(String name, String apellidos, Date fechaNacimiento, Date fechaIngreso, String RFC, String curp, String horario, String rol) {
        this.name = name;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.RFC = RFC;
        this.curp = curp;
        this.horario = horario;
        this.rol = rol;
        
    }
    
    public static Empleado registrarEmpleado (String name, String apellidos, Date fechaNacimiento, Date fechaIngreso, String RFC, String curp, String horario, String rol){
        Empleado empleado  = new Empleado();
        System.out.println("Registrando nuevo empleado: ");

        System.out.println("ingrese su fecha de nacimiento:");
        empleado.setFechaNacimiento(leerFecha());
        
        System.out.println("ingrese su rol: ");
       empleado.setRol(scanner.nextLine());
       
       
//establecer los demas atributos sobre el empleado
System.out.println("ingrese el horario: ");
empleado.setHorario(scanner.nextLine());
        System.out.println("ingrese el salario: ");
        empleado.setSalario(scanner.nextDouble());
        
        return empleado;
       
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
         System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
    }
    
    
    
      

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }



}