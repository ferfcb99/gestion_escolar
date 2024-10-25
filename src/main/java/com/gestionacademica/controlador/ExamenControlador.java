package com.gestionacademica.controlador;

import com.gestionacademica.entitie.Examen;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExamenControlador {

    ResponseEntity<List<Examen>> listarExamens();

    ResponseEntity<Examen> guardarExamen(Examen Examen);

    ResponseEntity<Examen> actualizarExamen(Examen Examen);

    ResponseEntity<String> eliminarExamen(Long id);

}
