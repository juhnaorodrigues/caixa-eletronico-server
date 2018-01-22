package com.governo.secretaria.security;

import com.governo.secretaria.security.entity.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

/**
 * Created by Juhnao on 1/11/18.
 */
@Component
public class JwtValidator {


    private String secret = "youtube";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

            jwtUser = new JwtUser();
            jwtUser.setLogin(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}