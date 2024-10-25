package com.gestionacademica.entitie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Parameter(description = "Identificador único del profesor, generado automáticamente.", example = "1")
    private Long id;

    @Valid
    @Parameter(description = "Nombre completo del profesor. Debe ser una cadena válida.", example = "Carlos García")    private String nombre;

    @Valid
    @Parameter(description = "Correo electrónico del profesor. Debe ser un correo electrónico válido.", example = "carlos.garcia@example.com")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    @Parameter(description = "Lista de clases asociadas al profesor. Relación uno a muchos. Esta relación es ignorada en la respuesta JSON.", hidden = true)
    private List<Clase> clases;

    // Getters y setters

    public Profesor() {}

    public Profesor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
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

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}