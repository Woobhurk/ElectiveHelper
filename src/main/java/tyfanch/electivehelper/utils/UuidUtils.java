package tyfanch.electivehelper.utils;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UuidUtils {
    private UuidUtils() {}

    public static String randUuid() {
        return randRawUuid().replace("-", "");
    }

    public static String randUuid(String name) {
        return randRawUuid(name).replace("-", "");
    }

    public static String randRawUuid() {
        return UUID.randomUUID().toString();
    }

    public static String randRawUuid(String name) {
        return UUID.fromString(name).toString();
    }
}
