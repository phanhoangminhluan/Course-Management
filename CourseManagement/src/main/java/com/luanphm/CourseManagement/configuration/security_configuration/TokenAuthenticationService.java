package com.luanphm.CourseManagement.configuration.security_configuration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;


public class TokenAuthenticationService {

    private static int DAYS = 10;

    private static int HOURS = 24;

    private static int MINUTES = 60;

    private static int SECONDS = 60;

    private static int MILLISECONDS = 1000;

    private static int EXPIRATION_TIME = DAYS * HOURS * MINUTES * SECONDS * MILLISECONDS; // 864 000 000 milliseconds = 10 days

    private static final String SECRECT = "NguyenDoTraMy";

    private static final String TOKEN_PREFIX = "Bearer";

    private static final String HEADER_STRING = "Authorization";


    public static void addAuthentication(HttpServletResponse response, String username) {
//        System.out.println("TokenAuthenticationService: addAuthentication()");
        String jwt = Jwts
                .builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRECT)
                .compact();
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
//        System.out.println("TokenAuthenticationService: getAuthentication");
        String token = request.getHeader(HEADER_STRING);
        String user = null;
        if (token != null) {
            user = Jwts.parser()
                    .setSigningKey(SECRECT)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
        }
        return user != null
                ? new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList())
                : null;
    }


}
