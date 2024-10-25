package com.gestionacademica.security.jwt;


import com.gestionacademica.entitie.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.time.expiration}")
    private String timeExpiration;


    public JwtUtils(){}

    public JwtUtils(String secretKey, String timeExpiration) {
        this.secretKey = secretKey;
        this.timeExpiration = timeExpiration;
    }

    public String generateAccessToken(String usuario) {
        return Jwts.builder()
                .setSubject(usuario)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpiration)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();

    }



    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction) {
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    public String getUserNameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    // Método actualizado para extraer todos los claims
    public Claims extractAllClaims(String token) {
        return Jwts.parser()                        // Usar parserBuilder() en lugar de parser()
                .setSigningKey(getSignatureKey())           // Ahora se pasa un objeto de tipo Key
                .build()                                   // Construimos el parser
                .parseClaimsJws(token)                     // Parseamos el token JWT
                .getBody();                                // Obtenemos el cuerpo (claims)
    }


    public Key getSignatureKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getSecretKey() {
        return secretKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    public String getTimeExpiration() {
        return timeExpiration;
    }
    public void setTimeExpiration(String timeExpiration) {
        this.timeExpiration = timeExpiration;
    }

}
