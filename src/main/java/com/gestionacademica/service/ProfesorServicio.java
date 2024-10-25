package com.gestionacademica.service;

import com.gestionacademica.entitie.Profesor;

import java.util.List;

public interface ProfesorServicio {

    List<Profesor> listarProfesors();

    Profesor crearProfesor(Profesor profesor);

    Profesor actualizarProfesor(Profesor profesor);

    void eliminarProfesor(Long id);
    
}
