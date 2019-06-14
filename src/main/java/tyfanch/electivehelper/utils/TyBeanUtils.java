package tyfanch.electivehelper.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean工具类
 */
public class TyBeanUtils {
    private TyBeanUtils() {}

    /**
     * 将Bean转化为Map
     *
     * @param object 要转化的Bean对象
     * @return 转化得到的Map
     */
    public static Map<String, Object> toMap(Object object) {
        Map<String, Object> map = new HashMap<>();
        Class aClass;
        Field[] declaredFields;

        if (object != null) {
            aClass = object.getClass();
            declaredFields = aClass.getDeclaredFields();

            for (Field declaredField : declaredFields) {
                try {
                    declaredField.setAccessible(true);
                    map.put(declaredField.getName(), declaredField.get(object));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    map.put(declaredField.getName(), null);
                }
            }
        }

        return map;
    }

    /**
     * 复制对象属性，将源对象的属性复制给目标对象的同名属性
     *
     * @param destObj 目标对象
     * @param srcObj 源对象
     * @return 目标对象
     */
    public static Object copyObject(Object destObj, Object srcObj) {
        Map<String, Object> srcFieldMap;
        Class destClass;

        if (srcObj != null && destObj != null) {
            destClass = destObj.getClass();
            srcFieldMap = toMap(srcObj);

            srcFieldMap.forEach((key, value) -> {
                if (value != null) {
                    try {
                        Field field = destClass.getDeclaredField(key);

                        field.setAccessible(true);
                        field.set(destObj, value);
                    } catch (NoSuchFieldException e) {
                        System.err.println("---- TyBeanUtils.copyObject: destObj has no `"
                            + key + "`");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        return destObj;
    }
}
