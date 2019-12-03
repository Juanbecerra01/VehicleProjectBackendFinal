package com.vehicle.vehicle.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordUtil {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String getHashedPassword(String password) {
        return encoder.encode(password);
    }
}
