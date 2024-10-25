package com.gestionacademica.representacion;

public class AlumnoRecomendacionRepresentacion extends AlumnoGeneral{


    String recomendacion;

    public AlumnoRecomendacionRepresentacion(String nombre, String recomendacion) {
        super(nombre);
        this.recomendacion = recomendacion;
    }

    public AlumnoRecomendacionRepresentacion(){}


    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

}
