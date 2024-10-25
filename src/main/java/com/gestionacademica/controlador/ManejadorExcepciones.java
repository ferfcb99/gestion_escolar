package com.gestionacademica.controlador;

import com.gestionacademica.representacion.RespuestaExcepcionRepresentacion;
import org.springframework.http.ResponseEntity;

public interface ManejadorExcepciones {

    ResponseEntity<RespuestaExcepcionRepresentacion> handleException(Exception e);

}
