package com.dsmanioto.productsapi.autentication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {

    public static String encrypt(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
