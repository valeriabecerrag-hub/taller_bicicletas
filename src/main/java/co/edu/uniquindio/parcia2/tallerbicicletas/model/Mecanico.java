package co.edu.uniquindio.parcia2.tallerbicicletas.model;

import co.edu.uniquindio.parcia2.tallerbicicletas.model.enums.EspecialidadMecanico;

public class Mecanico extends Persona{
    private EspecialidadMecanico especialidadMecanico;
    private int codigoInterno;

    public Mecanico() {
    }

    public Mecanico(EspecialidadMecanico especialidadMecanico, int codigoInterno, String nombre,
                    String numIdentifiacion) {
        super(nombre, numIdentifiacion);
        this.especialidadMecanico = especialidadMecanico;
        this.codigoInterno = codigoInterno;
    }

    public EspecialidadMecanico getEspecialidadMecanico() {
        return especialidadMecanico;
    }

    public void setEspecialidadMecanico(EspecialidadMecanico especialidadMecanico) {
        this.especialidadMecanico = especialidadMecanico;
    }

    public int getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(int codigoInterno) {
        this.codigoInterno = codigoInterno;
    }
}
