package com.gestionacademica.repository;

import com.gestionacademica.entitie.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota, Long> {
}
