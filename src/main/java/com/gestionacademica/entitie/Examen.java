package com.gestionacademica.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "examen")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Parameter(description = "Identificador único del examen, generado automáticamente.", example = "1")
    private Long id;

    @Valid
    @Parameter(description = "Nombre del examen. Debe ser una cadena válida.", example = "Examen Final")
    private String nombre;

    @Valid
    @Parameter(description = "Fecha en que se realizará el examen, en formato ISO-8601 (YYYY-MM-DD).", example = "2024-10-30")
    private LocalDate fechaExamen;

    @Valid
    @Parameter(description = "Asistencia mínima requerida para participar en el examen, valor en porcentaje (0 a 100).", example = "75.0")
    private Double asistenciaRequerida;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "clase_id")
    @Parameter(description = "Objeto que representa la clase a la que pertenece el examen. Esta relación es ignorada en la respuesta JSON.", hidden = true)
    private Clase clase;

    // Getters y setters

    public Examen(){}

    public Examen(Long id, LocalDate fechaExamen, String nombre, Double asistenciaRequerida, Clase clase) {
        this.id = id;
        this.fechaExamen = fechaExamen;
        this.nombre = nombre;
        this.asistenciaRequerida = asistenciaRequerida;
        this.clase = clase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public Double getAsistenciaRequerida() {
        return asistenciaRequerida;
    }

    public void setAsistenciaRequerida(Double asistenciaRequerida) {
        this.asistenciaRequerida = asistenciaRequerida;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }
}
