package co.edu.uniquindio.parcia2.tallerbicicletas.model;

public class Cliente extends Persona {
    private String direccion;
    private int telefono;

    public Cliente() {
        super();
    }

    public Cliente(String nombre, String numIdentificacion, String direccion, int telefono) {
        super(nombre, numIdentificacion);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
