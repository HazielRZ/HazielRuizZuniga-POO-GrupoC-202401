package Modelo;

import utils.ValidadorRFC;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Empleado extends Usuario {
    protected String rfc;
    protected List<Materia> materiasImpartidas;
    protected double sueldo;

    // Constructor
    public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, String sexo, String ciudad, String estado,
                    String direccion, LocalDate fechaRegistro, String rol, double sueldo) {
        super(nombre, apellidos, fechaNacimiento, sexo, ciudad, estado, direccion, fechaRegistro, rol);
        this.sueldo = sueldo;
        this.materiasImpartidas = new ArrayList<>();
        this.rfc = ValidadorRFC.generarRFC(this);
    }


    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public List<Materia> getMateriasImpartidas() {
        return materiasImpartidas;
    }

    public void setMateriasImpartidas(List<Materia> materiasImpartidas) {
        this.materiasImpartidas = materiasImpartidas;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
