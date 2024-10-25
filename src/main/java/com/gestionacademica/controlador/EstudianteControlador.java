package com.gestionacademica.controlador;

import com.gestionacademica.entitie.Estudiante;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EstudianteControlador {

    ResponseEntity<List<Estudiante>> listarEstudiantes();

    ResponseEntity<Estudiante> guardarEstudiante(Estudiante Estudiante);

    ResponseEntity<Estudiante> actualizarEstudiante(Estudiante Estudiante);

    ResponseEntity<String> eliminarEstudiante(Long id);

}
