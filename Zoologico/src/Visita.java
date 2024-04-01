import java.util.ArrayList;
import java.util.Scanner;

public class Visita {
    Scanner scanner = new Scanner(System.in);

    Empleado turnoGuia;
    ArrayList<Visitante> Visitantes = new ArrayList<Visitante>();
    private double costoTotalVisita;
    String fechaVisita;
    private int cantidadNiños;
    private int cantidadAdultos;
    private int numeroVisitas;

    public Visita(Empleado turnoGuia, double costoTotalVisita, String fechaVisita, int cantidadNiños, int cantidadAdultos) {
        this.turnoGuia = turnoGuia;
        this.costoTotalVisita = costoTotalVisita;
        this.fechaVisita = fechaVisita;
        this.cantidadNiños = cantidadNiños;
        this.cantidadAdultos = cantidadAdultos;
    }


    public int getNumeroVisitas() {
        return numeroVisitas;

    }

    public void setNumeroVisitas(int numeroVisitas) {
        this.numeroVisitas = numeroVisitas;
    }




    public Empleado getTurnoGuia() {
        return turnoGuia;
    }

    public void setTurnoGuia(Empleado turnoGuia) {
        this.turnoGuia = turnoGuia;
    }

    public ArrayList<Visitante> getVisitantes() {
        return Visitantes;
    }

    public void setVisitantes(ArrayList<Visitante> Visitantes) {
        this.Visitantes = Visitantes;

    }

    public double getCostoTotalVisita() {
        return costoTotalVisita;
    }

    public void setCostoTotalVisita(double costoTotalVisita) {
        this.costoTotalVisita = costoTotalVisita;


    }

    public String getFechaVisita() {
        return fechaVisita;

    }

    public void setFechaVisita(String fechaVisita) {
        this.fechaVisita = fechaVisita;

    }

    public int getCantidadNiños() {
        return cantidadNiños;
    }

    public void setCantidadNiños(int cantidadNiños) {
        this.cantidadNiños = cantidadNiños;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

}
