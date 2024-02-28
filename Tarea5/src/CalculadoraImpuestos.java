public class CalculadoraImpuestos {
    public double calcularImpuestos(int ingresos) {
        return ingresos + 0.15;
    }

    public double calcularImpuestos(double ventas, double porcentajeImpuestos) {
        return ventas * (porcentajeImpuestos / 100);
    }

    public double calcularImpuestos(double dividendos, double porcentajeImpuestos, double exencion) {
        double impuestos = dividendos * (porcentajeImpuestos / 100);
        if (impuestos > exencion) {
            return impuestos - exencion;
        } else {
            return 0;
        }
    }
}
