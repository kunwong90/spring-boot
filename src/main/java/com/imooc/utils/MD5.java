package com.imooc.utils;

import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5 {
    private static final Logger logger = LoggerFactory.getLogger(MD5.class);

    public MD5() {
    }

    public static String md5(String message) {
        return new String(Hex.encodeHex(md5Digest(message)));
    }

    private static byte[] md5Digest(String message) {
        byte[] md5Bytes = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md5Bytes = md.digest(message.getBytes(Charsets.UTF_8));
        } catch (NoSuchAlgorithmException var3) {
            logger.error("md5 error: NoSuchAlgorithmException");
        }

        return md5Bytes;
    }

    public static String getMD5(String s) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            logger.error("getMD5 error", e);
            throw new RuntimeException(e);
        }
    }
}
