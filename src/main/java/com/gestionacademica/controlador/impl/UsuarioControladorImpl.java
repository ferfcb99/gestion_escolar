package com.gestionacademica.controlador.impl;

import com.gestionacademica.controlador.UsuarioControlador;
import com.gestionacademica.entitie.Rol;
import com.gestionacademica.entitie.Usuario;
import com.gestionacademica.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioControladorImpl implements UsuarioControlador {

    private UsuarioRepositorio usuarioRepositorio;

//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UsuarioControladorImpl(UsuarioRepositorio usuarioRepositorio, PasswordEncoder passwordEncoder) {
//        this.usuarioRepositorio = usuarioRepositorio;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @PostMapping(value = "/create-user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
//
//        Set<Rol> roles = usuario.getRoles();
//        Usuario usuario1 = new Usuario();
//        usuario1.setId(usuario.getId());
//        usuario1.setUsuario(usuario.getUsuario());
//        usuario1.setClave(this.passwordEncoder.encode(usuario.getClave()));
//        usuario1.setEmail(usuario.getEmail());
//        usuario1.setRoles(roles);
//
//        return ResponseEntity.ok(this.usuarioRepositorio.save(usuario1));
//    };


}
