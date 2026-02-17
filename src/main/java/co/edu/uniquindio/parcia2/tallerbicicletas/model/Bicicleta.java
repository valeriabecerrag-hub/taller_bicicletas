package co.edu.uniquindio.parcia2.tallerbicicletas.model;

import co.edu.uniquindio.parcia2.tallerbicicletas.model.enums.TipoBicicleta;

public class Bicicleta  {

    private String marca;
    private TipoBicicleta tipoBicicleta;
    private String color;
    private String serial;
    private int anio;
    private Cliente cliente;

    public Bicicleta() {
    }

    public Bicicleta(String marca,
                     TipoBicicleta tipoBicicleta,
                     String color,
                     String serial,
                     int anio, Cliente cliente) {
        this.marca = marca;
        this.tipoBicicleta = tipoBicicleta;
        this.color = color;
        this.serial = serial;
        this.anio = anio;
        this.cliente = cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoBicicleta getTipoBicicleta() {
        return tipoBicicleta;
    }

    public void setTipoBicicleta(TipoBicicleta tipoBicicleta) {
        this.tipoBicicleta = tipoBicicleta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
