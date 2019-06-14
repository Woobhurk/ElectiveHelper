package tyfanch.electivehelper.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {
    private Base64Utils() {}

    public static String encode(String str) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes;
        String srcStr;
        String encodedStr;

        // 去除空行
        srcStr = str.replace("\n", "")
            .replace("\r", "")
            .replace("\r\n", "");
        bytes = srcStr.getBytes(StandardCharsets.UTF_8);
        encodedStr = new String(encoder.encode(bytes), StandardCharsets.UTF_8);

        // 去除空行
        return encodedStr.replace("\n", "")
            .replace("\r", "")
            .replace("\r\n", "");
    }

    public static String decode(String str) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes;
        String srcStr;
        String decodedStr;

        srcStr = str.replace("\n", "")
            .replace("\r", "")
            .replace("\r\n", "");
        bytes = srcStr.getBytes(StandardCharsets.UTF_8);
        decodedStr = new String(decoder.decode(bytes), StandardCharsets.UTF_8);

        return decodedStr.replace("\n", "")
            .replace("\r", "")
            .replace("\r\n", "");
    }

    public static String encodeMime(String str) {
        //Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
        //byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //
        //return new String(mimeEncoder.encode(bytes), StandardCharsets.UTF_8);
        return encode(str);
    }

    public static String decodeMime(String str) {
        //Base64.Decoder mimeDecoder = Base64.getMimeDecoder();
        //byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //
        //return new String(mimeDecoder.decode(bytes), StandardCharsets.UTF_8);
        return decode(str);
    }

    public static String encodeUrl(String str) {
        //Base64.Encoder urlEncoder = Base64.getUrlEncoder();
        //byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //
        //return new String(urlEncoder.encode(bytes), StandardCharsets.UTF_8);
        return encode(str);
    }

    public static String decodeUrl(String str) {
        //Base64.Decoder urlDecoder = Base64.getUrlDecoder();
        //byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        //
        //return new String(urlDecoder.decode(bytes), StandardCharsets.UTF_8);
        return decode(str);
    }
}
