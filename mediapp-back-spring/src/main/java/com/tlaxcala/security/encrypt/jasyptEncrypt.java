package com.tlaxcala.security.encrypt;

import org.jasypt.util.text.BasicTextEncryptor;
public class jasyptEncrypt {
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword("tlaxcala");

        String encryptedText = textEncryptor.encrypt("tlaxcala");
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
