package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.ControladorNegocio;
import com.gestionacademica.representacion.AlumnoDerechoExamenRepresentacion;
import com.gestionacademica.representacion.AlumnoRecomendacionRepresentacion;
import com.gestionacademica.representacion.PromedioAlumnoRepresentacion;
import com.gestionacademica.service.ServicioNegocio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Negocio", description = "Gestión de negocio")
@RestController
@RequestMapping(path = "/negocio")
public class ControladorNegocioImpl implements ControladorNegocio {

    private ServicioNegocio servicioNegocio;

    @Autowired
    public ControladorNegocioImpl(ServicioNegocio servicioNegocio) {
        this.servicioNegocio = servicioNegocio;
    }

    @Override
    @Operation(summary = "Obtener promedio de alumnos")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/promedios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PromedioAlumnoRepresentacion>> obtenerPromedioAlumnos() {
        return ResponseEntity.ok(this.servicioNegocio.obtenerPromedioAlumnoRepresentacion());
    }

    @Override
    @Operation(summary = "Obtener una recomendacion de cada alumno por id")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/recomendacion/{idAlumno}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlumnoRecomendacionRepresentacion> obtenerRecomendacionPorIdAlumno(Long idAlumno) {
        return ResponseEntity.ok(this.servicioNegocio.obtenerAlumnoRecomendacionRepresentacion(idAlumno));
    }

    @Override
    @Operation(summary = "Saber si un alumno tiene derecho a examen")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/derecho-examen/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlumnoDerechoExamenRepresentacion> tieneDerechoAExamen(Long id) {
        return ResponseEntity.ok(this.servicioNegocio.tieneDerechoAExamen(id));
    }


}
