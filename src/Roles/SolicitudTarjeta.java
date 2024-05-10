
package Roles;

import java.util.Scanner;


public class SolicitudTarjeta {
    Scanner scanner = new Scanner (System.in);
    int opcion = scanner.nextInt();
  public enum EstadoOpcion {
        NO_SELECCIONADO, SELECCIONADO, ACEPTADO, RECHAZADO
    }

    public enum Tarjeta {
        SIMPLICITY,
        PLATINO,
        ORO
    }

    private EstadoOpcion estadoSimplicity;
    private EstadoOpcion estadoPlatino;
    private EstadoOpcion estadoOro;
    private Tarjeta opcionSeleccionada; 

    public SolicitudTarjeta() {
        estadoSimplicity = EstadoOpcion.NO_SELECCIONADO;
        estadoPlatino = EstadoOpcion.NO_SELECCIONADO;
        estadoOro = EstadoOpcion.NO_SELECCIONADO;
        opcionSeleccionada = null; 
    }

    public boolean seleccionarTarjeta(Tarjeta tarjeta) {
        if (opcionSeleccionada != null) {
            System.out.println("Ya hay una tarjeta seleccionada. No se puede seleccionar otra hasta que se acepte o rechace.");
            return false;
        }

        switch (tarjeta) {
            case SIMPLICITY:
                estadoSimplicity = EstadoOpcion.SELECCIONADO;
                opcionSeleccionada = Tarjeta.SIMPLICITY;
                break;
            case PLATINO:
                estadoPlatino = EstadoOpcion.SELECCIONADO;
                opcionSeleccionada = Tarjeta.PLATINO;
                break;
            case ORO:
                estadoOro = EstadoOpcion.SELECCIONADO;
                opcionSeleccionada = Tarjeta.ORO;
                break;
        }

        System.out.println("Tarjeta " + tarjeta + " seleccionada.");
        return true;
    }

    public boolean aceptarTarjeta() {
        if (opcionSeleccionada == null) {
            System.out.println("No hay ninguna tarjeta seleccionada para aceptar.");
            return false;
        }

        switch (opcionSeleccionada) {
            case SIMPLICITY:
                estadoSimplicity = EstadoOpcion.ACEPTADO;
                break;
            case PLATINO:
                estadoPlatino = EstadoOpcion.ACEPTADO;
                break;
            case ORO:
                estadoOro = EstadoOpcion.ACEPTADO;
                break;
        }

        System.out.println("Tarjeta " + opcionSeleccionada + " aceptada.");
        opcionSeleccionada = null; // Resetear para permitir seleccionar otra
        return true;
    }

    public boolean rechazarTarjeta() {
        if (opcionSeleccionada == null) {
            System.out.println("No hay ninguna tarjeta seleccionada para rechazar.");
            return false;
        }

        switch (opcionSeleccionada) {
            case SIMPLICITY:
                estadoSimplicity = EstadoOpcion.RECHAZADO;
                break;
            case PLATINO:
                estadoPlatino = EstadoOpcion.RECHAZADO;
                break;
            case ORO:
                estadoOro = EstadoOpcion.RECHAZADO;
                break;
        }

        System.out.println("Tarjeta " + opcionSeleccionada + " rechazada.");
        opcionSeleccionada = null; 
        return true;
    }

    public void estadoActual() {
        System.out.println("Estado actual:");
        System.out.println("Tarjeta Simplicity: " + estadoSimplicity);
        System.out.println("Tarjeta Platino: " + estadoPlatino);
        System.out.println("Tarjeta Oro: " + estadoOro);
    }
    
    /*public void seleccionTarjeta(){
                SelectorTarjetasCredito selector = new SelectorTarjetasCredito();

        boolean continuar = true;

        while (continuar) {
            System.out.println("Elige una tarjeta (1: Simplicity, 2: Platino, 3: Oro):");
            

            switch (opcion) {
                case 1:
                    selector.seleccionarTarjeta(SelectorTarjetasCredito.Tarjeta.SIMPLICITY);
                    break;
                case 2:
                    selector.seleccionarTarjeta(SelectorTarjetasCredito.Tarjeta.PLATINO);
                    break;
                case 3:
                    selector.seleccionarTarjetasCredito.Tarjeta.ORO);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    continue;
            }

            System.out.println("¿Quieres aceptar la tarjeta seleccionada? (sí/no):");
            String respuesta = scanner.next().toLowerCase();

            if (respuesta.equals("sí")) {
                selector.aceptarTarjeta();
            } else if (respuesta.equals("no")) {
                selector.rechazarTarjeta();
            } else {
                System.out.println("Respuesta inválida.");
            }

            System.out.println("¿Deseas continuar seleccionando tarjetas? (sí/no):");
            String continuarRespuesta = scanner.next().toLowerCase();

            if (!continuarRespuesta.equals("sí")) {
                continuar = false;
            }

            selector.estadoActual();
        }

        System.out.println("Gracias por usar el sistema de selección de tarjetas.");
        scanner.close();
    }*/
}