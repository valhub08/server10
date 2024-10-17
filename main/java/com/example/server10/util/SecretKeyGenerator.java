package com.example.server10.util;

import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import io.jsonwebtoken.SignatureAlgorithm;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String secret = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Generated JWT Secret Key:");
        System.out.println(secret);
    }

}