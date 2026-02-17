package co.edu.uniquindio.parcia2.tallerbicicletas.helpers;

import co.edu.uniquindio.parcia2.tallerbicicletas.model.Bicicleta;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.Cliente;
import co.edu.uniquindio.parcia2.tallerbicicletas.model.Mecanico;

import java.util.ArrayList;

public class Helpers {

    public boolean validarExistenciaCliente(ArrayList<Cliente> clientes,String id){
        for (Cliente cliente : clientes){
            if(cliente.getNumIdentificacion().equals(id)){
                return false;
            }
        }
        return true;
    }

    public boolean validarExistenciaMecanico(ArrayList<Mecanico> mecanicos, String id){
        for (Mecanico mecanico : mecanicos){
            if(mecanico.getNumIdentificacion().equals(id)){
                return false;
            }
        }
        return true;
    }

    public boolean validarExistenciaBicicleta(ArrayList<Bicicleta> bicicletas, String serial){
        for (Bicicleta bicicleta : bicicletas){
            if(bicicleta.getSerial().equals(serial)){
                return false;
            }
        }
        return true;
    }
}
