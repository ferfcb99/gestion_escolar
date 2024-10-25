package com.gestionacademica.service.impl;

import com.gestionacademica.entitie.Usuario;
import com.gestionacademica.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    public UserDetailsServiceImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuarioDetalles = this.usuarioRepositorio.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + "no existe"));

        Collection<? extends GrantedAuthority> authorities = usuarioDetalles.getRoles().stream().map(rol ->
                new SimpleGrantedAuthority("ROLE_".concat(rol.getNombre().name())))
                .collect(Collectors.toSet());

        return new User(usuarioDetalles.getUsuario(), usuarioDetalles.getClave(), true, true, true, true, authorities);
    }
}
