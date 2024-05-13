
package Roles.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EjecutivoCuenta {
    
    private ArrayList<Persona> personas;

    public EjecutivoCuenta() {
        personas = new ArrayList<>();
    }

    public void agregarPersona(String nombre, String apellido) {
        personas.add(new Persona(nombre, apellido));
    }

    public Persona buscarPersona(String nombre, String apellido) {
        for (Persona persona : personas) {
            if (persona.getNombre().equals(nombre) && persona.getApellido().equals(apellido)) {
                return persona;
            }
        }
        return null;
    }

    public void modificarNombre(Persona persona, String nuevoNombre) {
        persona.setNombre(nuevoNombre);
    }

    public void modificarApellido(Persona persona, String nuevoApellido) {
        persona.setApellido(nuevoApellido);
    }

    public void eliminarPersona(Persona persona) {
        personas.remove(persona);
    }

    public void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            System.out.println("Personas registradas:");
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
    }
    
     
    
}
