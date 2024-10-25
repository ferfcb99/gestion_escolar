package com.gestionacademica.service.impl;

import com.gestionacademica.entitie.Estudiante;
import com.gestionacademica.entitie.Nota;
import com.gestionacademica.representacion.AlumnoDerechoExamenRepresentacion;
import com.gestionacademica.representacion.AlumnoRecomendacionRepresentacion;
import com.gestionacademica.representacion.PromedioAlumnoRepresentacion;
import com.gestionacademica.representacion.RespuestaExcepcionRepresentacion;
import com.gestionacademica.service.EstudianteServicio;
import com.gestionacademica.service.NotaServicio;
import com.gestionacademica.service.ServicioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicioNegocioImpl implements ServicioNegocio {

    private NotaServicio notaServicio;

    private EstudianteServicio estudianteServicio;

    @Autowired
    public ServicioNegocioImpl(NotaServicio notaServicio, EstudianteServicio estuServicio) {
        this.notaServicio = notaServicio;
        this.estudianteServicio = estuServicio;
    }

    @Override
    public List<PromedioAlumnoRepresentacion> obtenerPromedioAlumnoRepresentacion() {
        List<Estudiante> estudiantes = this.estudianteServicio.listarEstudiantes();
        List<PromedioAlumnoRepresentacion> promedioAlumnoRepresentacion = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            PromedioAlumnoRepresentacion promedioActual = new PromedioAlumnoRepresentacion();
            promedioActual.setPromedio(filtrarNotasPorIdAlumno(estudiante.getId()).getPromedioFinal());
            promedioActual.setNombre(estudiante.getNombre());
            promedioAlumnoRepresentacion.add(promedioActual);
        }
        return promedioAlumnoRepresentacion;
    }

    @Override
    public AlumnoRecomendacionRepresentacion obtenerAlumnoRecomendacionRepresentacion(Long id) {
        AlumnoRecomendacionRepresentacion recomendacion = new AlumnoRecomendacionRepresentacion();
        recomendacion.setRecomendacion("El alumno lo esta haciendo bien.");
        List<Estudiante> estudiantes = this.estudianteServicio.listarEstudiantes().stream().filter(estudiante -> {
            return estudiante.getId().equals(id);
        }).toList();

        try {
            Estudiante estudiante = estudiantes.get(0);
            Nota nota = filtrarNotasPorIdAlumno(estudiante.getId());
            if(nota.getPromedioFinal() < 70){
                recomendacion.setRecomendacion("El alumno necesita asesorias con urgencia.");
            }
            if(nota.getPromedioFinal() >= 70 && nota.getPromedioFinal() < 80){
                recomendacion.setRecomendacion("El alumno podria mejorar con asesorias.");
            }       recomendacion.setNombre(estudiante.getNombre());
        }catch(Exception e){
            throw new RuntimeException("Error al obtener la recomendacion del alumno.");
        }

        return recomendacion;
    }

    @Override
    public AlumnoDerechoExamenRepresentacion tieneDerechoAExamen(Long id) {
        AlumnoDerechoExamenRepresentacion derecho = new AlumnoDerechoExamenRepresentacion();
        derecho.setDerechoExamen(Boolean.FALSE);
        List<Estudiante> estudiantes = this.estudianteServicio.listarEstudiantes().stream().filter(estudiante -> {
            return estudiante.getId().equals(id);
        }).toList();

        try {
            Estudiante estudiante = estudiantes.get(0);
            derecho.setNombre(estudiante.getNombre());
            Nota nota = filtrarNotasPorIdAlumno(id);
            if(nota.getPromedioFinal() >= 90){
                derecho.setDerechoExamen(Boolean.TRUE);
            }
        }catch(Exception e){
            throw new RuntimeException("Error al calcular el derecho a examen");
        }
        return derecho;
    }

    @Override
    public Nota filtrarNotasPorIdAlumno(Long id){
       try {
           List<Nota> notas = this.notaServicio.listarNotas();
           for(Nota notaActual : notas){
               if(notaActual.getId().equals(id)){
                   return notaActual;
               }
           }
       }catch(Exception e){
           throw new RuntimeException("Error al calcular el promedio, existe una incosistencia en los datos");
       }
       return null;
    }
}
