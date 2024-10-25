package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.NotaControlador;
import com.gestionacademica.entitie.Nota;
import com.gestionacademica.service.NotaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Notas", description = "Gestión de notas")
@RestController
@RequestMapping(path = "/nota")
public class NotaControladorImpl implements NotaControlador {

    private NotaServicio notaServicio;

    @Autowired
    public NotaControladorImpl(NotaServicio notaServicio) {
        this.notaServicio = notaServicio;
    }


    @Override
    @Operation(summary = "Obtener lista de notas")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/obtener-todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Nota>> listarNotas() {
        return ResponseEntity.ok(this.notaServicio.listarNotas());
    }

    @Override
    @Operation(summary = "Guardar una nota")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Nota> guardarNota(@RequestBody Nota nota) {
        return ResponseEntity.ok(this.notaServicio.crearNota(nota));
    }

    @Override
    @Operation(summary = "Actualizar una nota")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Nota> actualizarNota(@RequestBody Nota nota) {
        return ResponseEntity.ok(this.notaServicio.actualizarNota(nota));
    }

    @Override
    @Operation(summary = "Eliminar una nota")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> eliminarNota(@PathVariable Long id) {
        this.notaServicio.eliminarNota(id);
        return ResponseEntity.ok("Nota eliminada");
    }
}
