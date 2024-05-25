package utils;

import Modelo.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ValidadorCURP {

    private static final Map<String, String> CLAVES_ENTIDADES = new HashMap<>();

    static {
        CLAVES_ENTIDADES.put("AGUASCALIENTES", "AS");
        CLAVES_ENTIDADES.put("BAJA CALIFORNIA", "BC");
        CLAVES_ENTIDADES.put("BAJA CALIFORNIA SUR", "BS");
        CLAVES_ENTIDADES.put("CAMPECHE", "CC");
        CLAVES_ENTIDADES.put("COAHUILA", "CL");
        CLAVES_ENTIDADES.put("COLIMA", "CM");
        CLAVES_ENTIDADES.put("CHIAPAS", "CS");
        CLAVES_ENTIDADES.put("CHIHUAHUA", "CH");
        CLAVES_ENTIDADES.put("CIUDAD DE MÉXICO", "DF");
        CLAVES_ENTIDADES.put("DURANGO", "DG");
        CLAVES_ENTIDADES.put("GUANAJUATO", "GT");
        CLAVES_ENTIDADES.put("GUERRERO", "GR");
        CLAVES_ENTIDADES.put("HIDALGO", "HG");
        CLAVES_ENTIDADES.put("JALISCO", "JC");
        CLAVES_ENTIDADES.put("MÉXICO", "MC");
        CLAVES_ENTIDADES.put("MICHOACÁN", "MN");
        CLAVES_ENTIDADES.put("MORELOS", "MS");
        CLAVES_ENTIDADES.put("NAYARIT", "NT");
        CLAVES_ENTIDADES.put("NUEVO LEÓN", "NL");
        CLAVES_ENTIDADES.put("OAXACA", "OC");
        CLAVES_ENTIDADES.put("PUEBLA", "PL");
        CLAVES_ENTIDADES.put("QUERÉTARO", "QT");
        CLAVES_ENTIDADES.put("QUINTANA ROO", "QR");
        CLAVES_ENTIDADES.put("SAN LUIS POTOSÍ", "SP");
        CLAVES_ENTIDADES.put("SINALOA", "SL");
        CLAVES_ENTIDADES.put("SONORA", "SR");
        CLAVES_ENTIDADES.put("TABASCO", "TC");
        CLAVES_ENTIDADES.put("TAMAULIPAS", "TS");
        CLAVES_ENTIDADES.put("TLAXCALA", "TL");
        CLAVES_ENTIDADES.put("VERACRUZ", "VZ");
        CLAVES_ENTIDADES.put("YUCATÁN", "YN");
        CLAVES_ENTIDADES.put("ZACATECAS", "ZS");
        CLAVES_ENTIDADES.put("NACIDO EXTRANJERO", "NE");
    }

    public static String generarCURP(Usuario usuario) {
        String nombre = limpiarNombre(usuario.getNombre());
        String[] apellidos = usuario.getApellidos().split(" ");
        String apellido1 = limpiarNombre(apellidos[0]);
        String apellido2 = apellidos.length > 1 ? limpiarNombre(apellidos[1]) : "X";

        // Asegurarse de que apellido1 tenga al menos 2 letras
        apellido1 = (apellido1.length() >= 2) ? apellido1.substring(0, 2) : apellido1 + "X";

        // Asegurarse de que apellido2 tenga al menos 1 letra
        apellido2 = (apellido2.length() >= 1) ? apellido2.substring(0, 1) : "X";

        LocalDate fechaNacimiento = usuario.getFechaNacimiento();

        String fechaNacimientoStr = fechaNacimiento.format(DateTimeFormatter.ofPattern("yyMMdd"));
        String sexo = usuario.getSexo();
        String entidadNacimiento = CLAVES_ENTIDADES.get(usuario.getEstado().toUpperCase());

        if (entidadNacimiento == null) {
            throw new IllegalArgumentException("Entidad de nacimiento inválida: " + usuario.getEstado());
        }

        String consonantesApellido1 = obtenerConsonantes(apellido1);
        String primeraVocalInternaApellido1 = obtenerPrimeraVocalInterna(apellido1);
        int anioNacimiento = fechaNacimiento.getYear();
        String homoclave = generarHomoclave(anioNacimiento);

        return apellido1.charAt(0) + primeraVocalInternaApellido1 + apellido2.charAt(0) +
                nombre.charAt(0) + fechaNacimientoStr + sexo + entidadNacimiento +
                consonantesApellido1.substring(1, Math.min(3, consonantesApellido1.length())) + homoclave;
    }

    // ... (otros métodos auxiliares: limpiarNombre, obtenerConsonantes, etc.)
    public static boolean validarCURP(String curp) {
        // 1. Verificar longitud y formato
        if (curp == null || curp.length() != 18 || !curp.matches("[A-Z]{4}\\d{6}[HM][A-Z]{2}[BCDFGHJKLMNPQRSTVWXYZ]{3}\\d{2}")) {
            return false;
        }

        // 2. Verificar dígito verificador
        int suma = 0;
        for (int i = 0; i < 16; i++) {
            char c = curp.charAt(i);
            int valor;
            if (Character.isDigit(c)) {
                valor = c - '0';
            } else {
                valor = c - 'A' + 10;
            }
            suma += valor * (18 - i);
        }
        int digitoVerificador = 10 - (suma % 10);
        if (digitoVerificador == 10) {
            digitoVerificador = 0;
        }
        return digitoVerificador == (curp.charAt(17) - '0');
    }

    private static String limpiarNombre(String nombre) {
        nombre = nombre.toUpperCase().trim();
        nombre = nombre.replaceAll("[^A-ZÑ]", "");
        return nombre;
    }

    private static String obtenerConsonantes(String palabra) {
        return palabra.replaceAll("[AEIOUÑ]", "");
    }

    private static String obtenerPrimeraVocalInterna(String palabra) {
        for (int i = 1; i < palabra.length(); i++) {
            if ("AEIOUÑ".indexOf(palabra.charAt(i)) != -1) {
                return String.valueOf(palabra.charAt(i));
            }
        }
        return "X";
    }

    private static String generarHomoclave(int anioNacimiento) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        Random random = new Random();

        if (anioNacimiento < 2000) {
            return String.valueOf(letras.charAt(random.nextInt(letras.length())) + numeros.charAt(random.nextInt(numeros.length())));
        } else {
            return String.valueOf(anioNacimiento).substring(2, 4) +
                    letras.charAt(random.nextInt(letras.length())) +
                    numeros.charAt(random.nextInt(numeros.length()));
        }
    }
}


