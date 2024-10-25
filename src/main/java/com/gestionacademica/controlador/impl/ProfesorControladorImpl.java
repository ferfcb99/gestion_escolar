package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.ProfesorControlador;
import com.gestionacademica.entitie.Profesor;
import com.gestionacademica.service.ProfesorServicio;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/profesor")
public class ProfesorControladorImpl implements ProfesorControlador {

    private ProfesorServicio profesorServicio;

    @Autowired
    public ProfesorControladorImpl(ProfesorServicio profesorServicio) {
        this.profesorServicio = profesorServicio;
    }

    @Override
    @Operation(summary = "Obtener lista de profesores")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/obtener-todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Profesor>> listarProfesors() {
        return ResponseEntity.ok(this.profesorServicio.listarProfesors());
    }

    @Override
    @Operation(summary = "Guardar un profesor")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> guardarProfesor(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(this.profesorServicio.crearProfesor(profesor));
    }

    @Override
    @Operation(summary = "Actualizar un profesor")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> actualizarProfesor(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(this.profesorServicio.actualizarProfesor(profesor));
    }

    @Override
    @Operation(summary = "Eliminar un profesor")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable Long id) {
        this.profesorServicio.eliminarProfesor(id);
        return ResponseEntity.ok("Profesor eliminado");
    }
}
