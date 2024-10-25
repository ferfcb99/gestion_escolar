package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.ManejadorExcepciones;
import com.gestionacademica.representacion.RespuestaExcepcionRepresentacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExcepcionesImpl implements ManejadorExcepciones {


    @Override
    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaExcepcionRepresentacion> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new RespuestaExcepcionRepresentacion("500", e.getMessage()));
    }
}
