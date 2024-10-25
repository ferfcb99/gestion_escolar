package com.gestionacademica.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionacademica.entitie.Usuario;
import com.gestionacademica.security.jwt.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JwtUtils jwtUtils;

    public JwtAuthenticationFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        Usuario usuario = null;
        String nombreUsuario = "";
        String claveUsuario = "";
        try{
            usuario = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
            nombreUsuario = usuario.getUsuario();
            claveUsuario = usuario.getClave();
            System.out.println("Usuario: " + usuario.getUsuario());
            System.out.println("Clave: " + usuario.getClave());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(nombreUsuario, claveUsuario);
        return getAuthenticationManager().authenticate(authenticationToken);
    }


    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String token = this.jwtUtils.generateAccessToken(user.getUsername());
        response.addHeader("Authorization", token);
        Map<String, Object>  httpResponse = new HashMap<>();

        httpResponse.put("token", token);
        httpResponse.put("Message", "Autenticacion Correcta");
        httpResponse.put("Username", user.getUsername());


        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json");
        response.getWriter().flush();

    }

}
