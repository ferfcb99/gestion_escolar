package com.gestionacademica.entitie;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "clase")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Parameter(description = "Identificador único de la clase", example = "1")
    private Long id;

    @Valid
    @Parameter(description = "Nombre de la clase. Debe ser una cadena válida.", example = "Matemáticas")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    @Valid
    @Parameter(description = "Objeto que representa el profesor a cargo de la clase. Asociado mediante la clave foránea `profesor_id`.", required = true)
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
            name = "clase_estudiante",
            joinColumns = @JoinColumn(name = "clase_id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id"))
    @Valid
    @Parameter(description = "Lista de estudiantes asignados a la clase. Relación de muchos a muchos.", example = "[{\"id\":1,\"nombre\":\"Estudiante 1\"},{\"id\":2,\"nombre\":\"Estudiante 2\"}]")
    private List<Estudiante> estudiantes;

    @Parameter(description = "Lista de exámenes asignados a la clase. Relación de uno a muchos.", example = "[{\"id\":1,\"nombre\":\"Examen parcial\"},{\"id\":2,\"nombre\":\"Examen final\"}]")
    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL)
    private List<Examen> examenes;

    // Getters y setters

    public Clase(){}

    public Clase(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }
}