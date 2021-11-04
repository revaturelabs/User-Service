package com.reverse.userservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
public class ReverseJWT {

    private Logger logger = LoggerFactory.getLogger(ReverseJWT.class);

    @Getter
    private String token;

    private static int tokenLife = 3600;
    private UUID uuid;


    public ReverseJWT(Long userID, String secret) {
        this.uuid = UUID.randomUUID();

        this.generateToken(userID, secret);
    }


    /**
     * Generates the JWT token with object attributes.
     * @param userID The userId for the new token
     */
    private void generateToken(Long userID, String secret) {

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));

        token = Jwts.builder().setSubject(String.valueOf(userID)).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenLife * 1000)).signWith(key, SignatureAlgorithm.HS512)
                .setId(this.uuid.toString()).compact();
    }

    /**
     * Gets the userId from the JWT. Returns null if the signature is invalid.
     * @return The username from the JWT. Null if the JWT is invalid
     */
    @JsonIgnore
    public Long getUserID(String secret) {
        try {
            Long userID = Long.parseLong(Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody().getSubject());
            return userID;
        } catch(SignatureException e) {
            logger.info("JWT invalid!");
        } catch(ExpiredJwtException e) {
            logger.debug("JWT expired!");
        } catch(NumberFormatException e) {
            logger.warn("JWTSubject NAN!");
        }
        return null;
    }
}
