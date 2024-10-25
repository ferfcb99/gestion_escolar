package com.gestionacademica.controladores;

import com.gestionacademica.controlador.impl.ControladorNegocioImpl;
import com.gestionacademica.representacion.AlumnoDerechoExamenRepresentacion;
import com.gestionacademica.representacion.AlumnoRecomendacionRepresentacion;
import com.gestionacademica.representacion.PromedioAlumnoRepresentacion;
import com.gestionacademica.service.ServicioNegocio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ControladorNegocioImplTest {

    @Mock
    private ServicioNegocio servicioNegocio;

    @InjectMocks
    private ControladorNegocioImpl controladorNegocioImpl = new ControladorNegocioImpl(servicioNegocio);

    List<PromedioAlumnoRepresentacion> listaPromedioAlumnoRepresentacion = new ArrayList<PromedioAlumnoRepresentacion>();
    AlumnoRecomendacionRepresentacion alumno = new AlumnoRecomendacionRepresentacion();
    AlumnoDerechoExamenRepresentacion examen = new AlumnoDerechoExamenRepresentacion();

    @BeforeEach
    public void setUp() {
        listaPromedioAlumnoRepresentacion.add(new PromedioAlumnoRepresentacion("Javier",2.2));
        alumno.setNombre("Javier");
        examen.setNombre("Javier");
    }

    @Test
    public void obtenerPromedioAlumnosTest(){
        Mockito.when(this.servicioNegocio.obtenerPromedioAlumnoRepresentacion()).thenReturn(this.listaPromedioAlumnoRepresentacion);
        this.controladorNegocioImpl.obtenerPromedioAlumnos();
    }

    @Test
    public void obtenerRecomendacionPorIdAlumnoTest(){
        Mockito.when(this.servicioNegocio.obtenerAlumnoRecomendacionRepresentacion(1L)).thenReturn(this.alumno);
        this.controladorNegocioImpl.obtenerRecomendacionPorIdAlumno(1L);
    }

    @Test
    public void tieneDerechoAExamenTest(){
        Mockito.when(this.servicioNegocio.tieneDerechoAExamen(1L)).thenReturn(this.examen);
        this.controladorNegocioImpl.tieneDerechoAExamen(1L);
    }

}
