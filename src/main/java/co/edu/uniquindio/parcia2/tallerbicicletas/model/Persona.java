package co.edu.uniquindio.parcia2.tallerbicicletas.model;

public class Persona {

    private String nombre;
    private String numIdentificacion;

    public Persona(String nombre, String numIdentificacion) {
        this.nombre = nombre;
        this.numIdentificacion = numIdentificacion;
    }

    public Persona() {

    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
