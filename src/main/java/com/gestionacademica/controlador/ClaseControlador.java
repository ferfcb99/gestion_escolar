package com.gestionacademica.controlador;

import com.gestionacademica.entitie.Clase;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClaseControlador {

    ResponseEntity<List<Clase>> listarClases();

    ResponseEntity<Clase> guardarClase(Clase clase);

    ResponseEntity<Clase> actualizarClase(Clase clase);

    ResponseEntity<String> eliminarClase(Long id);

}
