package com.example.demo.NHSLogin;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class TokenService {

    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS512;
    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    public static String getJws(String clientId, String tokenUri) {
        try {
            // Private keys should be accessed securely, and not stored in the repository in production!
            String privateKeyContent = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("keys/private_key.pem").toURI())));

            privateKeyContent = privateKeyContent
                    .replaceAll("\\n", "")
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "");

            Key signingKey = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyContent)));

            return Jwts.builder()
                    .setSubject(clientId)
                    .setIssuer(clientId)
                    .setId(UUID.randomUUID().toString())
                    .setAudience(tokenUri)
                    .setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.MINUTES)))
                    .signWith(signingKey, signatureAlgorithm).compact();
        } catch (Exception e) {
            logger.error("error whilst signing jwt", e);
            return null;
        }
    }
}
