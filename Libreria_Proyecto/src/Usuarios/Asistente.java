
package Usuarios;

import Usuarios.Utils.Rol;
import java.time.LocalDate;


public class Asistente extends Usuario
{
    private LocalDate fechaInicio;
    private double sueldo;
    private String RFC;

    public Asistente( double sueldo, String RFC, String nombre, String apellido, String telefono, String  nombreUsuario, String contrasena) 
    {
        
        super(nombre, apellido, telefono, Rol.ASISTENTE, nombreUsuario, contrasena);
       // this.fechaInicio = fechaInicio;
        this.sueldo = sueldo;
        this.RFC = RFC;
    }
    
    
    @Override
    public String toString()
    {
        return String.format("%s \nSueldo: %.2f \nRFC: %s \nFecha de inicio: %s ",super.toString(), sueldo, RFC, fechaInicio);
    }
    
}
