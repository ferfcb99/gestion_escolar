package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.ClaseControlador;
import com.gestionacademica.entitie.Clase;
import com.gestionacademica.service.ClaseServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clases", description = "Gestión de clases")
@RestController
@RequestMapping(path = "/clase")
public class ClaseControladorImpl implements ClaseControlador {

    private ClaseServicio claseServicio;

    @Autowired
    public ClaseControladorImpl(ClaseServicio claseServicio) {
        this.claseServicio = claseServicio;
    }

    @Override
    @Operation(summary = "Obtener lista de clases")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/obtener-todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Clase>> listarClases() {
        return ResponseEntity.ok(this.claseServicio.listarClases());
    }

    @Override
    @Operation(summary = "Guardar una clase")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clase> guardarClase(@RequestBody Clase clase) {
        return ResponseEntity.ok(this.claseServicio.crearClase(clase));
    }

    @Override
    @Operation(summary = "Actualizar una clase")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Clase> actualizarClase(@RequestBody Clase clase) {
        return ResponseEntity.ok(this.claseServicio.actualizarClase(clase));
    }

    @Override
    @Operation(summary = "Eliminar una clase")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> eliminarClase(@PathVariable Long id) {
        this.claseServicio.eliminarClase(id);
        return ResponseEntity.ok("Clase eliminada exitosamente");
    }
}
