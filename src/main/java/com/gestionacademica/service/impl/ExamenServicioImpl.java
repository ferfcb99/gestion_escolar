package com.gestionacademica.service.impl;

import com.gestionacademica.entitie.Examen;
import com.gestionacademica.repository.ExamenRepositorio;
import com.gestionacademica.service.ExamenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenServicioImpl implements ExamenServicio {

    private ExamenRepositorio examenRepositorio;

    @Autowired
    public ExamenServicioImpl(ExamenRepositorio examenRepositorio) {
        this.examenRepositorio = examenRepositorio;
    }

    @Override
    public List<Examen> listarExamens() {
        return this.examenRepositorio.findAll();
    }

    @Override
    public Examen crearExamen(Examen examen) {
        return this.examenRepositorio.save(examen);
    }

    @Override
    public Examen actualizarExamen(Examen examen) {
        if (examenRepositorio.existsById(examen.getId())) {
            return examenRepositorio.save(examen);
        }
        throw new RuntimeException("Examen no encontrado");    }

    @Override
    public void eliminarExamen(Long id) {
        if (examenRepositorio.existsById(id)) {
            examenRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Examen no encontrado");
        }
    }
}
