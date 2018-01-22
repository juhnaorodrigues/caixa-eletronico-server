package com.governo.secretaria.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Juhnao on 1/16/18.
 */
public class Util {

    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(
                    1, 3));
        }

        return sb.toString();
    }

    public static String md5(String message) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        return hex(md.digest(message.getBytes("CP1252")));
    }

}
