package com.gestionacademica.controlador;

import com.gestionacademica.entitie.Nota;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface NotaControlador {

    ResponseEntity<List<Nota>> listarNotas();

    ResponseEntity<Nota> guardarNota(Nota Nota);

    ResponseEntity<Nota> actualizarNota(Nota Nota);

    ResponseEntity<String> eliminarNota(Long id);

}
