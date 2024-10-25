package com.gestionacademica.entitie;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Parameter(description = "Identificador único del estudiante, generado automáticamente.", example = "1")
    private Long id;

    @Valid
    @Parameter(description = "Nombre del estudiante. Debe ser una cadena válida.", example = "Juan Pérez")
    private String nombre;

    @Valid
    @Parameter(description = "Correo electrónico del estudiante. Debe ser un correo electrónico válido.", example = "juan.perez@example.com")
    private String email;

    @Valid
    @Parameter(description = "Promedio de asistencia del estudiante en porcentaje. Valor entre 0 y 100.", example = "85.5")
    private Double promedioAsistencia;

    @JsonIgnore
    @Parameter(description = "Lista de notas asociadas al estudiante. Esta relación es ignorada en la respuesta JSON.", hidden = true)
    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private List<Nota> notas;

    // Getters y setters

    public Estudiante() {
    }

    public Estudiante(String nombre, String email, Double promedioAsistencia) {

        this.nombre = nombre;
        this.email = email;
        this.promedioAsistencia = promedioAsistencia;

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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPromedioAsistencia() {
        return promedioAsistencia;
    }

    public void setPromedioAsistencia(Double promedioAsistencia) {
        this.promedioAsistencia = promedioAsistencia;
    }
    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {

        this.notas = notas;
    }


}