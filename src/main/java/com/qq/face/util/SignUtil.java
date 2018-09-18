package com.qq.face.util;

import com.imooc.utils.MD5;

import java.util.Map;

public final class SignUtil {

    private SignUtil() {

    }
    public static String sign(Object object, String appKey) throws Exception {
        Map<String, String> map = MapConvertUtil.convertObject2Map(object);
        String str = MapConvertUtil.convertMap2Str(map) + "&app_key=" + appKey;
        return MD5.md5(str).toUpperCase();
    }
}
