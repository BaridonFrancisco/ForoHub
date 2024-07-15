package com.baridonfrancisco.forohub.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baridonfrancisco.forohub.domain.user.User;
import jakarta.websocket.DecodeException;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {


    public String generateToken(User user){
        /*debe llevar una clave unica para los tokens el algoritmo
        * que sirve para decodificar o codificar el hash del codigo encriptado*/
        try {

            Algorithm algorithm = Algorithm.HMAC256(System.getenv("secret_key"));
           return JWT.create()
                    .withIssuer("forohub")
                    .withClaim("id", user.getUsername())
                    .withExpiresAt(getInstant())// tiempo de expiracion del token
                    .withSubject(user.getUsername())
                    .sign(algorithm).trim();

        } catch (Exception e) {
           throw new RuntimeException("Token cant not generated");

        }


    }

    public String getSubject(String token){
        DecodedJWT decodedJWT;
        try{
            Algorithm algorithm=Algorithm.HMAC256(System.getenv("secret_key"));
            decodedJWT=JWT.require(algorithm)
                    .withIssuer("forohub")
                    .build()
                    .verify(token);
            return decodedJWT.getSubject();

        }catch (JWTVerificationException e){
            System.out.println("verification  token fail");
        }
        throw new RuntimeException("verificacion token");
    }


    private Instant getInstant(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
