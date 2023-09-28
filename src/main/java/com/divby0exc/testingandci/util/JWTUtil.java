package com.divby0exc.testingandci.util;

import com.divby0exc.testingandci.model.Account;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JWTUtil {

    static final String SECRET_KEY = "wsvdoiphj;sdcvio[jwesvrdffio[jfd";
    static final long EXP_TIME = (1000 * 60) * 60;
    public static String sign(Account account) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts
                .builder()
                .claim("username", account.getUsername())
                .claim("role", account.getAccountType())
                .setExpiration(new Date(System.currentTimeMillis()
                        + EXP_TIME))
                .signWith(key)
                .compact();
    }

    public static boolean verify(String token) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parse(token) != null;
    }
}
