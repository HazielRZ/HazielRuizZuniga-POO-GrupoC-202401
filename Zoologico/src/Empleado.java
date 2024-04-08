import java.util.Date;

public class Empleado {
    private int id;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private String RFC;
    private String curp;
    private double salario = 0;
    private String horario;
    private String rol; // mantenimiento, veterinario, guia, administracion

    public Empleado(int id, String nombre, String apellidos, Date fechaNacimiento, Date fechaIngreso,
                    String RFC, String curp, double salario, String horario, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.RFC = RFC;
        this.curp = curp;
        this.salario = salario;
        this.horario = horario;
        this.rol = rol;
    }

    public Empleado(String nombreGuia) {
    }


    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaIngreso=" + fechaIngreso +
                ", RFC='" + RFC + '\'' +
                ", curp='" + curp + '\'' +
                ", salario=" + salario +
                ", horario='" + horario + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }
}
