package tyfanch.electivehelper.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 */
public class Md5Utils {
    private Md5Utils() {}

    public static void main(String[] args) {
        System.out.println(toMd5("tempPassword"));
    }

    /**
     * 计算给定数据的MD5值
     *
     * @param src 源字符串
     * @return 生成的MD5字符串
     */
    public static String toMd5(String src) {
        MessageDigest md5;
        String rawMd5Str;
        StringBuilder md5StrSb = new StringBuilder();
        byte[] md5Bytes;

        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.update(src.getBytes());
            md5Bytes = md5.digest();
            rawMd5Str = new BigInteger(1, md5Bytes).toString(16);

            // 左补0
            for (int i = rawMd5Str.length(); i < 32; i++) {
                md5StrSb.append("0");
            }

            // 将未补齐的md5串追加到结尾处
            md5StrSb.append(rawMd5Str);
        } catch (NoSuchAlgorithmException e) {
            // 失败则返回源字符串
            md5StrSb.delete(0, md5StrSb.toString().length());
            md5StrSb.append(src);
            e.printStackTrace();
        }

        return md5StrSb.toString();
    }
}
