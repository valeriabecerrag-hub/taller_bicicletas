package co.edu.uniquindio.parcia2.tallerbicicletas.model;

import co.edu.uniquindio.parcia2.tallerbicicletas.helpers.Helpers;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.enums.EspecialidadMecanico;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.enums.TipoBicicleta;

import java.util.ArrayList;

public class Taller {
    private String nombre;
    private String direccion;
    private ArrayList<Cliente>clientes;
    private ArrayList<Mecanico> mecanicos ;
    private ArrayList<Bicicleta> bicicletas;
    private ArrayList<OrdenServicio> ordenes;
    private Helpers helpers;

    public Taller() {
        helpers = new Helpers();
        clientes = new ArrayList<>();
        mecanicos = new ArrayList<>();
        bicicletas = new ArrayList<>();
        ordenes = new ArrayList<>();
    }

    public Taller(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        clientes = new ArrayList<>();
        mecanicos = new ArrayList<>();
        bicicletas = new ArrayList<>();
        ordenes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(ArrayList<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

    public ArrayList<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }

    public ArrayList<OrdenServicio> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<OrdenServicio> ordenes) {
        this.ordenes = ordenes;
    }

    public boolean registrarCliente(String nombre, String numIdentificacion, String direccion, int telefono){

        if(helpers.validarExistenciaCliente(clientes, numIdentificacion)){
            Cliente cliente = new Cliente(nombre, numIdentificacion, direccion, telefono);
            clientes.add(cliente);
            return true;
        }else{
            return false;
        }
    }

    public boolean registrarMecanico(EspecialidadMecanico especialidadMecanico, int codigoInterno, String nombre, String numIdentificacion  ){
        if(helpers.validarExistenciaMecanico(mecanicos, numIdentificacion)){
            Mecanico mecanico = new Mecanico(especialidadMecanico, codigoInterno, nombre, numIdentificacion);
            mecanicos.add(mecanico);
            return true;
        }else{
            return false;
        }
    }

    public boolean registrarBicicleta(Cliente cliente, String marca, TipoBicicleta tipo, String color, String serial, int anio){
        if(helpers.validarExistenciaBicicleta(bicicletas, serial)){
            Bicicleta bicicleta = new Bicicleta(marca, tipo, color, serial, anio, cliente);
            bicicletas.add(bicicleta);
            return true;
        }
        return false;
    }



    public void crearOrdenServicio(){

    }

    public void registrarMecanicos(){

    }

    public void buscarHisoriaBicicleta(){

    }

    public void consultarOdenesPorDia(){

    }
}
