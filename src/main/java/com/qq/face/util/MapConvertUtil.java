package com.qq.face.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.qq.face.entity.FaceRequestVo;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class MapConvertUtil {

    public static Map<String, String> convertObject2Map(Object object) throws Exception {
        return convertObject2Map(object, false);
    }

    /**
     * @param object
     * @param parent 是否获取父类字段属性
     * @return
     */
    public static Map<String, String> convertObject2Map(Object object, boolean parent) throws Exception {
        Map<String, String> map = new TreeMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            JSONField jsonField = field.getAnnotation(JSONField.class);
            String value = (String) field.get(object);
            if (StringUtils.isNotBlank(value)) {
                if (jsonField != null) {
                    //如果不为空,说明该字段上使用了JSONField注解
                    String fieldName = jsonField.name();
                    map.put(fieldName, value);
                } else {
                    map.put(field.getName(), value);
                }
            }

        }
        Class<?> superClazz = object.getClass().getSuperclass();
        if (parent && superClazz != null && superClazz != Object.class) {
            convertObject2Map(superClazz.newInstance(), true);
        }
        return map;
    }


    public static String convertMap2Str(Map<String, String> map) throws Exception {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            if (StringUtils.isNotBlank(value)) {
                builder.append(entry.getKey()).append("=").append(URLEncoder.encode(value, "utf-8")).append("&");
            }
        }
        return builder.subSequence(0, builder.length() - 1).toString();
    }

    public static void main(String[] args) throws Exception {
        FaceRequestVo faceRequestVo = new FaceRequestVo();
        Map<String, String> map = convertObject2Map(faceRequestVo, false);
        System.out.println(map);
        System.out.println(convertMap2Str(map));
    }
}
