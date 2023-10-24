//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCreator {
    public HashCreator() {
    }

    public byte[] createMD5Hash(String input) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(input.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
        }

        return digest;
    }

    public static String md5ByteToString(byte[] hash) {
        BigInteger bigInt = new BigInteger(1, hash);

        String md5Hex;
        for(md5Hex = bigInt.toString(16); md5Hex.length() < 32; md5Hex = "0" + md5Hex) {
        }

        return md5Hex;
    }
}
