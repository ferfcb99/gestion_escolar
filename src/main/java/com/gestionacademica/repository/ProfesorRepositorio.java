package com.gestionacademica.repository;

import com.gestionacademica.entitie.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {

    @Query("SELECT p FROM Profesor p")
    List<Profesor> finAllProfesores();

}
