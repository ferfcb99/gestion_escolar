package com.gestionacademica.representacion;

import com.gestionacademica.entitie.Rol;
import jakarta.persistence.*;

import java.util.Set;

public class CrearUsuarioRepresentacion {

    private String email;


    private String usuario;


    private String clave;
    private Set<Rol> roles;


    public CrearUsuarioRepresentacion() {}


    public CrearUsuarioRepresentacion(String email, String usuario, String clave, Set<Rol> roles) {
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
