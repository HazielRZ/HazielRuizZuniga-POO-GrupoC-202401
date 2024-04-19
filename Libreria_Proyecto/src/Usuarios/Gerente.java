
package Usuarios;

import Usuarios.Utils.Rol;

public class Gerente extends Usuario
{
    private double sueldo;
    private String INE;

    public Gerente(double sueldo, String INE, String nombre, String apellido, String telefono, String nombreUsuario, String contrasena) 
    {
        super(nombre, apellido, telefono, Rol.GERENTE, nombreUsuario,contrasena);
        this.sueldo = sueldo;
        this.INE = INE;
    }
    
    
    @Override
    public String toString()
    {
        return String.format("%s \nSueldo: %.2f \nINE: %s ",super.toString(), sueldo, INE);
    }
  
}
