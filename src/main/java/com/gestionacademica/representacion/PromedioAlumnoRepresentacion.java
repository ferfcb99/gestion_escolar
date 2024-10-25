package com.gestionacademica.representacion;

public class PromedioAlumnoRepresentacion extends AlumnoGeneral {

    Double promedio;

    public PromedioAlumnoRepresentacion(String nombre, Double promedio) {
        super(nombre);
        this.promedio = promedio;
    }

    public PromedioAlumnoRepresentacion(){}



    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }


}
