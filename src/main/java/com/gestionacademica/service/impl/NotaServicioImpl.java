package com.gestionacademica.service.impl;

import com.gestionacademica.entitie.Nota;
import com.gestionacademica.repository.NotaRepositorio;
import com.gestionacademica.service.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServicioImpl implements NotaServicio {

    private NotaRepositorio notaRepositorio;

    @Autowired
    public NotaServicioImpl(NotaRepositorio notaRepositorio) {
        this.notaRepositorio = notaRepositorio;
    }

    @Override
    public List<Nota> listarNotas() {
        return notaRepositorio.findAll();
    }

    @Override
    public Nota crearNota(Nota nota) {
        return notaRepositorio.save(nota);
    }

    @Override
    public Nota actualizarNota(Nota nota) {
        if (notaRepositorio.existsById(nota.getId())) {
            return notaRepositorio.save(nota);
        }
        throw new RuntimeException("Nota no encontrada");
    }

    @Override
    public void eliminarNota(Long id) {
        if (notaRepositorio.existsById(id)) {
            notaRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Nota no encontrada");
        }
    }
}
