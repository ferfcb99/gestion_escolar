package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.ExamenControlador;
import com.gestionacademica.entitie.Examen;
import com.gestionacademica.service.ExamenServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Examenes", description = "Gestión de examenes")
@RestController
@RequestMapping(path = "/examen")
public class ExamenControladorImpl implements ExamenControlador {

    private ExamenServicio examenServicio;

    @Autowired
    public ExamenControladorImpl(ExamenServicio examenServicio) {
        this.examenServicio = examenServicio;
    }

    @Override
    @Operation(summary = "Obtener lista de examenes")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/obtener-todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Examen>> listarExamens() {
        return ResponseEntity.ok(examenServicio.listarExamens());
    }

    @Override
    @Operation(summary = "Crear un examen")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Examen> guardarExamen(@RequestBody Examen examen) {
        return ResponseEntity.ok(this.examenServicio.crearExamen(examen));
    }

    @Override
    @Operation(summary = "Actualizar un examen")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Examen> actualizarExamen(@RequestBody Examen examen) {
        return ResponseEntity.ok(this.examenServicio.actualizarExamen(examen));
    }

    @Override
    @Operation(summary = "Eliminar un examen")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> eliminarExamen(@PathVariable  Long id) {
        this.eliminarExamen(id);
        return ResponseEntity.ok("Examen eliminado");
    }
}
