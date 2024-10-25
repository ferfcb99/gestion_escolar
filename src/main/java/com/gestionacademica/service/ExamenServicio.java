package com.gestionacademica.service;

import com.gestionacademica.entitie.Examen;

import java.util.List;

public interface ExamenServicio {
    
    List<Examen> listarExamens();

    Examen crearExamen(Examen examen);

    Examen actualizarExamen(Examen examen);

    void eliminarExamen(Long id);
    
    
}
