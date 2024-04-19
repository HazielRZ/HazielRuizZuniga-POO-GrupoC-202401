
package Usuarios;

import Usuarios.Utils.Rol; //Importamos el enum
import java.time.LocalDate;

public class Cliente extends Usuario
{
    //Dato tipo fecha
    public LocalDate fechaRegistro; // LocalDate guarda fechas, se ocupa importar la librería
    
    public Cliente(String nombre, String apellido, String telefono, String nombreUsuario, String contrasena)
    {
        super(nombre, apellido, telefono, Rol.CLIENTE, nombreUsuario, contrasena);
        
        this.fechaRegistro = LocalDate.now();
    }
    
    
    
//    @Override //sobreescritura de metodo que tiene el mismo nombre en otra clase
//    public String mostrarInfo()
//    {
//        return String.format("%s \nFecha registro: %s", super.mostrarInfo(), fechaRegistro);
//    }
    
    @Override
    public String toString()
    {
        return String.format("%s \nFecha de registro: %s",super.toString(), fechaRegistro);
    }
    
    
    
    
    
}
