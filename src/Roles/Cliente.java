package Roles;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Cliente {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    StringBuilder numerosAleatorios = new StringBuilder();
//Datos personales sobre el cliente
    private String nombre, apellido, RFC, añoNacimieno, estado, ciudad, CURP, direccion, sucursalRegistro, fechaRegsitro;
    //Datos sobre la tarjeta del cliente
    private String numeroTarjeta, CVV, clabeInterbancaria, fechaVencimiento, fechaUso;
    private Date fechaCreacion = new Date(), fecha;
    double saldo;

    public Cliente(String nombre, String apellido, String RFC, String añoNacimieno, String estado, String ciudad, String CURP, String direccion, String sucursalRegistro, String fechaRegsitro, String numeroTarjeta, String CVV, String clabeInterbancaria, String fechaVencimiento, String fechaUso, Date fechaCreacion, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.RFC = RFC;
        this.añoNacimieno = añoNacimieno;
        this.estado = estado;
        this.ciudad = ciudad;
        this.CURP = CURP;
        this.direccion = direccion;
        this.sucursalRegistro = sucursalRegistro;
        this.fechaRegsitro = fechaRegsitro;
        this.numeroTarjeta = numeroTarjeta;
        this.CVV = CVV;
        this.clabeInterbancaria = clabeInterbancaria;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaUso = fechaUso;
        this.fechaCreacion = fechaCreacion;
        this.saldo = saldo;
    }

    public void registrarCliente() {
        System.out.println("ingrese el nombre del ususario: ");
        String nombre = scanner.nextLine();
        System.out.println("ingrese el apellido del usuario: ");
        String apellido = scanner.nextLine();
        System.out.println("ingrese fecha de nacimiento: ");
        String fechaNacimiento = scanner.nextLine();
        System.out.println("ingrese estado en el que nacio: ");
        String estado = scanner.nextLine();
        System.out.println("ingrese ciudad de nacimiento: ");
        String ciudad = scanner.nextLine();
        System.out.println("ingrese su direccion actual: ");
        String direccion = scanner.nextLine();
        System.out.println("ingrese su RFC: ");
        String RFC = scanner.nextLine();
        System.out.println("ingrese sucursal de registro: ");
        String sucursal = scanner.nextLine();
        }
    
    // creacion de la tarjeta de credito
    public void tarjetaDebito(){
         // Generar 16 números aleatorios para la tarjeta
        for (int i = 0; i < 16; i++) {
            int numero = random.nextInt(10);
            numerosAleatorios.append(numero);
        }
        String resultado = numerosAleatorios.toString();
        System.out.println("Estos son los 16 digitos de su tarjeta " + resultado);
        System.out.println("La fecha de creacion de la tarjeta es: ");
        System.out.println(fecha.getTime());
        System.out.println("el saldo de la tarjeta incial es de: $0.00, lo invitamos a realizar su primer deposito");
        // Generar 18 números aleatorios para la clabe interbancaria 
        for (int i = 0; i < 18; i++) {
            int inter = random.nextInt(10);
            numerosAleatorios.append(inter);
        }
                String clabe = numerosAleatorios.toString();
                System.out.println("Esta es su clave interbancaria: "+ clabe);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public StringBuilder getNumerosAleatorios() {
        return numerosAleatorios;
    }

    public void setNumerosAleatorios(StringBuilder numerosAleatorios) {
        this.numerosAleatorios = numerosAleatorios;
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

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getAñoNacimieno() {
        return añoNacimieno;
    }

    public void setAñoNacimieno(String añoNacimieno) {
        this.añoNacimieno = añoNacimieno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSucursalRegistro() {
        return sucursalRegistro;
    }

    public void setSucursalRegistro(String sucursalRegistro) {
        this.sucursalRegistro = sucursalRegistro;
    }

    public String getFechaRegsitro() {
        return fechaRegsitro;
    }

    public void setFechaRegsitro(String fechaRegsitro) {
        this.fechaRegsitro = fechaRegsitro;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getClabeInterbancaria() {
        return clabeInterbancaria;
    }

    public void setClabeInterbancaria(String clabeInterbancaria) {
        this.clabeInterbancaria = clabeInterbancaria;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(String fechaUso) {
        this.fechaUso = fechaUso;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
