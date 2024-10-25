package com.gestionacademica.service;

import com.gestionacademica.entitie.Clase;

import java.util.List;

public interface ClaseServicio {

    List<Clase> listarClases();

    Clase crearClase(Clase clase);

    Clase actualizarClase(Clase clase);

    void eliminarClase(Long id);

}
