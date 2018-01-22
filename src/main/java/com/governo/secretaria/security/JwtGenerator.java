package com.governo.secretaria.security;

import com.governo.secretaria.security.entity.JwtUser;
import com.governo.secretaria.util.Util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 * Created by Juhnao on 1/11/18.
 */
@Component
public class JwtGenerator {

    /**
     * Metodo para gerar o token com as informações do usuário.
     * @param jwtUser possui as informações do usuario encontrado no banco de dados.
     * @return token gerado.
     */
    public String generate(JwtUser jwtUser) {

        Claims claims = Jwts.claims().setSubject(jwtUser.getLogin());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "youtube").compact();
    }
}
