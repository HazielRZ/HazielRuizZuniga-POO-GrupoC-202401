import Fachada.Fachada;
import Modelo.Usuario;

public class MenuPrincipal extends Menu {
    private final Usuario usuarioActual;

    public MenuPrincipal(Fachada fachada, Usuario usuarioActual) {
        super(fachada);
        this.usuarioActual = usuarioActual;
    }

    @Override
    public void mostrar() {
        System.out.println("\nMENÚ PRINCIPAL");
        System.out.println("1. Consultar información personal");
        System.out.println("2. Cerrar sesión");

        // Opciones adicionales según el rol del usuario
        switch (usuarioActual.getRol()) {
            case "Alumno":
                System.out.println("3. Consultar calificaciones");
                break;
            case "Profesor":
                System.out.println("3. Registrar calificaciones");
                System.out.println("4. Consultar grupos");
                break;
            case "Coordinador":
                System.out.println("3. Registrar alumno");
                System.out.println("4. Registrar profesor");
                System.out.println("5. Avanzar semestre");
                break;
        }

        int opcion = leerOpcion();

        switch (opcion) {
            case 1:
                mostrarInformacionPersonal();
                break;
            case 2:
                cerrarSesion();
                break;
            case 3:
                // ... (lógica para la opción 3 según el rol)
                break;
            // ... (casos para las demás opciones)
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void mostrarInformacionPersonal() {
        // ... (lógica para mostrar la información del usuario)
    }

    private void cerrarSesion() {
        // ... (lógica para cerrar sesión)
    }

    // ... (otros métodos del menú principal)
}
