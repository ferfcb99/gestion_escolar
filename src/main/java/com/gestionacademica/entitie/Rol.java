package com.gestionacademica.entitie;

import com.gestionacademica.enumeradores.ERol;
import jakarta.persistence.*;


@Entity
@Table(name = "rol")
public class Rol {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERol nombre;


    public Rol(Long id, ERol nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Rol() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ERol getNombre() {
        return nombre;
    }

    public void setNombre(ERol nombre) {
        this.nombre = nombre;
    }
}
