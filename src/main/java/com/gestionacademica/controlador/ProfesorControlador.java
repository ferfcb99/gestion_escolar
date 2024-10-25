package com.gestionacademica.controlador;

import com.gestionacademica.entitie.Profesor;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProfesorControlador {

    ResponseEntity<List<Profesor>> listarProfesors();

    ResponseEntity<Profesor> guardarProfesor(Profesor Profesor);

    ResponseEntity<Profesor> actualizarProfesor(Profesor Profesor);

    ResponseEntity<String> eliminarProfesor(Long id);

}
