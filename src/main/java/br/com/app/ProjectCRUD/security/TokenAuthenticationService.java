package br.com.app.ProjectCRUD.security;

import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class TokenAuthenticationService {

    final long EXPIRATION_TIME = 860_000_000;
    final String SECRET = "{jwt.secret}";
    final String TOKEN_PREFIX = "Bearer";
    final String HEADER_STRING = "Authorization";

    static void addAuthentication(HttpServletResponse response, String username) {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
    }

}
