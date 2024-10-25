package com.gestionacademica.service.impl;

import com.gestionacademica.entitie.Clase;
import com.gestionacademica.repository.ClaseRepositorio;
import com.gestionacademica.service.ClaseServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServicioImpl implements ClaseServicio {

    private ClaseRepositorio claseRepositorio;

    @Autowired
    public ClaseServicioImpl(ClaseRepositorio claseRepositorio) {
        this.claseRepositorio = claseRepositorio;
    }

    @Override
    public List<Clase> listarClases() {
        return claseRepositorio.findAll();
    }

    @Override
    public Clase crearClase(Clase clase) {
        return claseRepositorio.save(clase);
    }

    @Override
    public Clase actualizarClase(Clase clase) {
        if (claseRepositorio.existsById(clase.getId())) {
            return claseRepositorio.save(clase);
        }
        throw new RuntimeException("Clase no encontrada");
    }

    @Override
    public void eliminarClase(Long id) {
        if (claseRepositorio.existsById(id)) {
            claseRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Clase no encontrada");
        }
    }
}
