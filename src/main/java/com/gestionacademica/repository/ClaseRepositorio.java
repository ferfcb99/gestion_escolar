package com.gestionacademica.repository;

import com.gestionacademica.entitie.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepositorio extends JpaRepository<Clase, Long> {
}
