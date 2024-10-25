package com.gestionacademica.service;

import com.gestionacademica.entitie.Nota;
import com.gestionacademica.representacion.AlumnoDerechoExamenRepresentacion;
import com.gestionacademica.representacion.AlumnoRecomendacionRepresentacion;
import com.gestionacademica.representacion.PromedioAlumnoRepresentacion;

import java.util.List;

public interface ServicioNegocio {

    List<PromedioAlumnoRepresentacion> obtenerPromedioAlumnoRepresentacion();

    AlumnoRecomendacionRepresentacion obtenerAlumnoRecomendacionRepresentacion(Long id);

    AlumnoDerechoExamenRepresentacion tieneDerechoAExamen(Long id);

    Nota filtrarNotasPorIdAlumno(Long id);
}
