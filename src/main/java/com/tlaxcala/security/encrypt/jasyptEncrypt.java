package com.tlaxcala.security.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;
public class jasyptEncrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("tlaxcala");

        String encryptedText = textEncryptor.encrypt("aEIu9S7cvZUnPJWezau3rKUCxj4BLtpCVzhVSyam93prJOxofs7688P0OD5tmTIsLL6u7G9HpXvT");
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
