package com.gestionacademica.service;

import com.gestionacademica.entitie.Estudiante;

import java.util.List;

public interface EstudianteServicio {

    List<Estudiante> listarEstudiantes();

    Estudiante crearEstudiante(Estudiante estudiante);

    Estudiante actualizarEstudiante(Estudiante estudiante);

    void eliminarEstudiante(Long id);

}
