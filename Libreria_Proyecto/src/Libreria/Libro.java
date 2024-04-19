package Libreria;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private int aoPublicacion;
    private boolean disponible;

    public Libro(String titulo, String autor, String genero, int aoPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.aoPublicacion = aoPublicacion;
        this.disponible = true; // Al registrar un libro, por defecto se considera disponible
    }

    // Getters y setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAoPublicacion() {
        return aoPublicacion;
    }

    public void setAoPublicacion(int aoPublicacion) {
        this.aoPublicacion = aoPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", añoPublicacion=" + aoPublicacion +
                ", disponible=" + disponible +
                '}';
    }

    public void devolver() {
    }

    public void prestar() {
    }


    public int getCantidadCopias() {
        return 0;
    }
}
