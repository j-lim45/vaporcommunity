/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pong.vapor;

import java.util.Base64;

/**
 *
 * @author Adriane
 */
public class Password {
    // Safest encryption method ever designed

    static String encryptPassword(String plainText) {
        return Base64.getEncoder().encodeToString(plainText.getBytes());
    }

    static String decryptPassword(String encryptedString) {
        return new String(Base64.getDecoder().decode(encryptedString));
    }

    static boolean comparePasswords(String accountPasswordInDatabase, String passwordInputted) {
        if (encryptPassword(passwordInputted).equals(accountPasswordInDatabase))    return true;
        else                                                                        return false;
    }
}

