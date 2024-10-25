package com.gestionacademica.entitie;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Parameter(description = "Identificador único de la nota, generado automáticamente.", example = "1")
    private Long id;

    @Valid
    @Parameter(description = "Calificación obtenida en el examen. Debe ser un valor numérico.", example = "85.0")
    private Double examen;

    @Valid
    @Parameter(description = "Calificación obtenida en la tarea. Debe ser un valor numérico.", example = "90.0")
    private Double tarea;

    @Valid
    @Parameter(description = "Calificación obtenida en el proyecto. Debe ser un valor numérico.", example = "92.5")
    private Double proyecto;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    @Parameter(description = "Estudiante asociado a esta nota. Relación con la entidad Estudiante.", hidden = true)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "clase_id")
    @Parameter(description = "Clase asociada a esta nota. Relación con la entidad Clase.", hidden = true)
    private Clase clase;

    @Valid
    @Parameter(description = "Promedio final calculado a partir de las calificaciones del examen, tarea y proyecto.", example = "89.2")
    private Double promedioFinal;

    // Getters y setters


    public Nota(){}

    public Nota(Long id, Double promedioFinal, Clase clase, Estudiante estudiante, Double proyecto, Double tarea, Double examen) {
        this.id = id;
        this.promedioFinal = promedioFinal;
        this.clase = clase;
        this.estudiante = estudiante;
        this.proyecto = proyecto;
        this.tarea = tarea;
        this.examen = examen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getExamen() {
        return examen;
    }

    public void setExamen(Double examen) {
        this.examen = examen;
    }

    public Double getTarea() {
        return tarea;
    }

    public void setTarea(Double tarea) {
        this.tarea = tarea;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Double getProyecto() {
        return proyecto;
    }

    public void setProyecto(Double proyecto) {
        this.proyecto = proyecto;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Double getPromedioFinal() {
        return promedioFinal;
    }

    public void setPromedioFinal(Double promedioFinal) {
        this.promedioFinal = promedioFinal;
    }
}