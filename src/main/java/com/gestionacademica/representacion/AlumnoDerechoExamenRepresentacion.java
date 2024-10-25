package com.gestionacademica.representacion;

public class AlumnoDerechoExamenRepresentacion extends AlumnoGeneral{


    Boolean derechoExamen;

    public AlumnoDerechoExamenRepresentacion() {
        super();
    }

    public AlumnoDerechoExamenRepresentacion(String nombre, Boolean derechoExamen) {
        super(nombre);
        this.derechoExamen = derechoExamen;
    }

    public Boolean getDerechoExamen() {
        return derechoExamen;
    }

    public void setDerechoExamen(Boolean derechoExamen) {
        this.derechoExamen = derechoExamen;
    }



}
