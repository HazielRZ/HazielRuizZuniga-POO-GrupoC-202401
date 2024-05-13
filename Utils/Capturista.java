
package Roles.Utils;

import java.util.Date;

public class Capturista extends Empleado{
    
    
    
    public Capturista(Date fecha, String capturista, String gerente, String ejecutivoVentas, String id) {
        super(fecha, capturista, gerente, ejecutivoVentas, id);
    }
    
    public void aceptarRegsitro(){
        System.out.println("---ACEPTAR O RECHAZAR REGISTRO---");
        System.out.println("ingrese '1' para ACEPTAR    el registro, ingrese '2' para RECHAZAR el registro: ");
        int aceptarRegistro = scanner.nextInt();
        
    }
    public void modificarRegistro(){
        
    }
    
}
