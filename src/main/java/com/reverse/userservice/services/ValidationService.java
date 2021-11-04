package com.reverse.userservice.services;


import com.reverse.userservice.models.Credentials;
import com.reverse.userservice.models.ReverseJWT;

public interface ValidationService {

    /**
     * Sets the secret key used for JWTs
     * @param secret The secret key
     */
    void setSecret(String secret);

    /**
     * Validates submitted Credentials and returns a JWT if correct.
     * @param loginRequest The username and password stored in a credentials object.
     * @return JWT implementation.
     * @throws Exception Throws Exception if credentials invalid.
     */
    ReverseJWT validateCredentials(Credentials loginRequest) throws Exception;

    /**
     * Checks that a jwt is valid.
     * @param jwt The jwt to be validated.
     * @return true if valid, false if invalid.
     */
    boolean validateJwt(ReverseJWT jwt);

    /**
     * Checks if a jwt is valid, and that the value matches a userID.
     * @param jwt The jwt to be validated.
     * @param userID The long to be checked against the jwt body.
     * @return true if valid, false if invalid.
     */
    boolean validateJwt(ReverseJWT jwt, long userID);
}
