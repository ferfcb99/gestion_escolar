package com.gestionacademica.controlador;

import com.gestionacademica.representacion.AlumnoDerechoExamenRepresentacion;
import com.gestionacademica.representacion.AlumnoRecomendacionRepresentacion;
import com.gestionacademica.representacion.PromedioAlumnoRepresentacion;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControladorNegocio {

    ResponseEntity<List<PromedioAlumnoRepresentacion>> obtenerPromedioAlumnos();

    ResponseEntity<AlumnoRecomendacionRepresentacion> obtenerRecomendacionPorIdAlumno(Long idAlumno);

    ResponseEntity<AlumnoDerechoExamenRepresentacion> tieneDerechoAExamen(Long id);
}
