package com.gestionacademica.repository;

import com.gestionacademica.entitie.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepositorio extends JpaRepository<Examen, Long> {
}
