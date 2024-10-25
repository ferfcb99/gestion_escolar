package com.gestionacademica;

import com.gestionacademica.entitie.Rol;
import com.gestionacademica.entitie.Usuario;
import com.gestionacademica.enumeradores.ERol;
import com.gestionacademica.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaGestionAcademicaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaGestionAcademicaApplication.class, args);


    }

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Bean
    CommandLineRunner init(){
        return args -> {
            Set<Rol> roles = new HashSet<>();
            roles.add(new Rol(null, ERol.ADMIN));

          Usuario usuario = new Usuario();
          usuario.setUsuario("prueba");
          usuario.setClave("1234");
          usuario.setEmail("prueba@gmail.com");
          usuario.setRoles(roles);

          usuarioRepositorio.save(usuario);
        };
    }

}
