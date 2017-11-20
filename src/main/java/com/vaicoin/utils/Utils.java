/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaicoin.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;

import org.bouncycastle.crypto.generators.RSAKeyPairGenerator;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;

/**
 *
 * @author vaibhav
 */
public class Utils {

    public static byte[] getRandomBytes(int count) {
        byte[] bytes = new byte[count];
        new SecureRandom().nextBytes(bytes);
        return bytes;
    }
    
    // generate 2048-bit sized RSA key pair
    public static AsymmetricCipherKeyPair generateKeyPair() {
        RSAKeyPairGenerator generator = new RSAKeyPairGenerator();
        generator.init(new RSAKeyGenerationParameters(
                new BigInteger("101011", 16),
                new SecureRandom(),
                2048,
                80));
        return generator.generateKeyPair();
    }
}
