package org.example.security;

import java.util.Base64;

public class Security {
    public static String encryption(String password){
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(password.getBytes());
    }

    public static String decryption(String encodedPassword){
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(encodedPassword);
        return new String(bytes);
    }

}
