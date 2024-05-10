package Roles;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Inversionista {
    Scanner scanner = new Scanner(System.in);
    private Date fechaCreacion = new Date(), fecha;

    public Inversionista(Date fecha, String nombre, String id) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.id = id;
    }

    private String nombre;
    private String id;
    private double fondoMadero, fondeAcueducto;

  
    
    public void fondoBancoMadero(){
        System.out.println("ingrese el fondo que provera al banco de Madero: ");
        double fondoMadero = scanner.nextDouble();
        System.out.println("Este movimiento se realizo en la fecha: ");
        System.out.println(fecha.getTime());
        System.out.println("gracias por invertir en la sucursal Madero.");
    }
    
    public void fondoBancoAcueducto(){
        System.out.println("ingrese el fondo que provera al banco de Acueducto: ");
        double fondoAcueducto= scanner.nextDouble();
        System.out.println("Este movimiento se realizo en la fecha: ");
        System.out.println(fecha.getTime());
        System.out.println("gracias por invertir en la sucursal Acueducto.");
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Inversionista)) {
            return false;
        }
        Inversionista that = (Inversionista) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Inversionista{"
                + "nombre='" + nombre + '\''
                + ", id='" + id + '\''
                + '}';
    }
}

// Clase para registrar inversionistas y administrar la lista
class RegistroInversionistas {

    private List<Inversionista> inversionistas;

    public RegistroInversionistas() {
        this.inversionistas = new ArrayList<>();
    }

    public void agregarInversionista(Inversionista inversionista) {
        if (!inversionistas.contains(inversionista)) {
            inversionistas.add(inversionista);
            System.out.println("Inversionista agregado: " + inversionista);
        } else {
            System.out.println("Inversionista ya está registrado.");
        }
    }

    public void eliminarInversionista(String id) {
        Inversionista inversionistaAEliminar = null;
        for (Inversionista inv : inversionistas) {
            if (inv.getId().equals(id)) {
                inversionistaAEliminar = inv;
                break;
            }
        }
        if (inversionistaAEliminar != null) {
            inversionistas.remove(inversionistaAEliminar);
            System.out.println("Inversionista eliminado: " + inversionistaAEliminar);
        } else {
            System.out.println("Inversionista con ID " + id + " no encontrado.");
        }
    }

    public void listarInversionistas() {
        System.out.println("Lista de inversionistas:");
        for (Inversionista inv : inversionistas) {
            System.out.println(inv);
        }
    }
}
