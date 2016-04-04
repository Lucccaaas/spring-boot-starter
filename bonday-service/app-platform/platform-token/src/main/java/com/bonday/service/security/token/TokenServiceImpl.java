package com.bonday.service.security.token;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.text.ParseException;

/**
 * Created by yunge on 16/4/1.
 */
@Service(value = "tokenService")
public class TokenServiceImpl implements TokenService {

    public String generateToken(String message) throws SecurityException {
        Payload payload = new Payload(message);
        // Create JWS header with HS256 algorithm
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
        // Create JWS object
        JWSObject jwsObject = new JWSObject(header, payload);
        // Create HMAC signer
        String sharedKey = TokenService.key;
        JWSSigner signer;
        try {
            signer = new MACSigner(sharedKey.getBytes());
        } catch (KeyLengthException e) {
            throw new SecurityException(e.getMessage(), e.getCause());
        }
        try {
            jwsObject.sign(signer);
        } catch (JOSEException e) {
            throw new SecurityException(e);
        }
        return jwsObject.serialize();
    }

    public String getMessageFromToken(String token) throws SecurityException {
        // Parse back and check signature
        JWSObject jwsObject1;
        try {
            jwsObject1 = JWSObject.parse(token);
        } catch (ParseException e) {
            throw new SecurityException("pase error", e.getCause());
        }
        JWSVerifier verifier;
        try {
            verifier = new MACVerifier(TokenService.key.getBytes());
        } catch (JOSEException e) {
            throw new SecurityException(e.getMessage(), e.getCause());
        }
        boolean verifiedSignature = false;
        try {
            verifiedSignature = jwsObject1.verify(verifier);
        } catch (JOSEException e) {
            throw new SecurityException("Couldn't verify signature: "
                    + e.getMessage(), e.getCause());
        }
        if (verifiedSignature) {
            return jwsObject1.getPayload().toString();
        } else {
            throw new SecurityException("Couldn't verify signature");
        }
    }
}
