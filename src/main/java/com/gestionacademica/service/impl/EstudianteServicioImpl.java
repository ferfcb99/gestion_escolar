package com.gestionacademica.service.impl;

import com.gestionacademica.entitie.Estudiante;
import com.gestionacademica.repository.EstudianteRepositorio;
import com.gestionacademica.service.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServicioImpl implements EstudianteServicio {

    private EstudianteRepositorio estudianteRepositorio;

    @Autowired
    public EstudianteServicioImpl(EstudianteRepositorio estudianteRepositorio) {
        this.estudianteRepositorio = estudianteRepositorio;
    }

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    @Override
    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepositorio.save(estudiante);
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        if (estudianteRepositorio.existsById(estudiante.getId())) {
            return estudianteRepositorio.save(estudiante);
        }
        throw new RuntimeException("Estudiante no encontrado");
    }

    @Override
    public void eliminarEstudiante(Long id) {
        if (estudianteRepositorio.existsById(id)) {
            estudianteRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Estudiante no encontrado");
        }
    }
}
