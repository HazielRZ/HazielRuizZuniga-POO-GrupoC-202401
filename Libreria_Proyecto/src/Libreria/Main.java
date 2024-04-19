package Libreria;

import Usuarios.Asistente;
import Usuarios.Gerente;
import Usuarios.Utils.Rol;
import Usuarios.Cliente;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        Cliente cliente = new Cliente("haziel", "ruiz", "45646", "HZR", "123");
        Asistente asistente = new Asistente(1, "f312", "Juan", "Ruiz", "3324234", "JR", "4312");
        Gerente gerente = new Gerente(123, "Ger92", "gerente", "eder", "23423", "gerente", "alo");
        libreria.registrarCliente(cliente);
        libreria.registrarAsistente(asistente);
        libreria.registrarGerente(gerente);
        System.out.println(Rol.ASISTENTE);
        System.out.println(cliente.fechaRegistro);
        System.out.println(cliente.mostrarInfo());
        System.out.println(cliente);
        System.out.println();

        Menu objetoMenu = new Menu(libreria); // Pasa la instancia de Libreria al constructor de Menu
        objetoMenu.iniciarSesion();
    }
}

