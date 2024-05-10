
package Roles;

import java.util.Scanner;

public class Sucursales {
    Scanner scanner = new Scanner(System.in);
   private String gerente;
   private String nombre, apellido, id;

    public Sucursales(String gerente, String nombre, String apellido, String id) {
        this.gerente = gerente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }
   
   public void registrarGerente(){
       System.out.println("ingrese el nombre del gerente: " );
       String nombreGerente = scanner.nextLine();
       System.out.println("inrese el apellido del gerente: ");
       String apellidoGerente = scanner.nextLine();
       System.out.println("El gerente a cargo de esta sucursal es: "+ nombre+ apellido);
   }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
   
   
}
