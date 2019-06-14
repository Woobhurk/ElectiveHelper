package tyfanch.electivehelper.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlUtils {
    private UrlUtils() {}

    public static String encode(String src) throws UnsupportedEncodingException {
        return URLEncoder.encode(src, StandardCharsets.UTF_8.toString());
    }

    public static String decode(String src) throws UnsupportedEncodingException {
        return URLDecoder.decode(src, StandardCharsets.UTF_8.toString());
    }
}
