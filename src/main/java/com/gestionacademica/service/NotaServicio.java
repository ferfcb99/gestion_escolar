package com.gestionacademica.service;

import com.gestionacademica.entitie.Nota;

import java.util.List;

public interface NotaServicio {

    List<Nota> listarNotas();

    Nota crearNota(Nota nota);

    Nota actualizarNota(Nota nota);

    void eliminarNota(Long id);
    
}
