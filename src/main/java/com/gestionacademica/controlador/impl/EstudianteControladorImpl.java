package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.EstudianteControlador;
import com.gestionacademica.entitie.Estudiante;
import com.gestionacademica.service.EstudianteServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Estudiantes", description = "Gestión de estudiantes")
@RestController
@RequestMapping(path = "/estudiante")
public class EstudianteControladorImpl implements EstudianteControlador {

    private EstudianteServicio estudianteServicio;

    @Autowired
    public EstudianteControladorImpl(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    @Override
    @Operation(summary = "Obtener lista de estudiantes")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/obtener-todos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        return ResponseEntity.ok(estudianteServicio.listarEstudiantes());
    }

    @Override
    @Operation(summary = "Guardar un estudiante")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/guardar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(this.estudianteServicio.crearEstudiante(estudiante));
    }

    @Override
    @Operation(summary = "Actualizar un estudiante")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/actualizar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> actualizarEstudiante(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(this.estudianteServicio.actualizarEstudiante(estudiante));
    }

    @Override
    @Operation(summary = "Eliminar un estudiante")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> eliminarEstudiante(@PathVariable Long id) {
        this.estudianteServicio.eliminarEstudiante(id);
        return ResponseEntity.ok("Estudiante eliminado");
    }
}
