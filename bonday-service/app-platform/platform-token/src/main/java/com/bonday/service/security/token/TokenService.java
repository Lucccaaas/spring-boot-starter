package com.bonday.service.security.token;

/**
 * Created by yunge on 16/4/1.
 */
public interface TokenService {
    public static final String key = "com.bonday.service.info@bonday.shanghai.123456";

    String generateToken(String message) throws SecurityException;

    String getMessageFromToken(String token) throws SecurityException;
}
