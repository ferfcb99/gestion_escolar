package com.gestionacademica.service.impl;

import com.gestionacademica.entitie.Profesor;
import com.gestionacademica.repository.ProfesorRepositorio;
import com.gestionacademica.service.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServicioImpl implements ProfesorServicio {

    private ProfesorRepositorio profesorRepositorio;

    @Autowired
    public ProfesorServicioImpl(ProfesorRepositorio profesorRepositorio) {
        this.profesorRepositorio = profesorRepositorio;
    }

    @Override
    public List<Profesor> listarProfesors() {
        return profesorRepositorio.finAllProfesores();
    }

    @Override
    public Profesor crearProfesor(Profesor profesor) {
        return profesorRepositorio.save(profesor);
    }

    @Override
    public Profesor actualizarProfesor(Profesor profesor) {
        if (profesorRepositorio.existsById(profesor.getId())) {
            return profesorRepositorio.save(profesor);
        }
        throw new RuntimeException("Profesor no encontrado");
    }


    @Override
    public void eliminarProfesor(Long id) {
        if (profesorRepositorio.existsById(id)) {
            if (profesorRepositorio.existsById(id)) {
                profesorRepositorio.deleteById(id);
            } else {
                throw new RuntimeException("Profesor no encontrado");
            }
        }
    }
}