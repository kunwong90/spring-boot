package com.http.util;

import com.qq.face.entity.FaceRequestVo;
import com.qq.face.util.FileBase64Util;
import com.qq.face.util.MapConvertUtil;
import com.qq.face.util.SignUtil;
import com.squareup.okhttp.*;

import java.io.File;
import java.io.IOException;

public final class OkHttpClientUtil {

    private OkHttpClientUtil() {

    }

    public static final MediaType JSON_CONTENT_TYPE
            = MediaType.parse("application/json; charset=utf-8");



    public static String post(String url, String json) throws IOException {
        return post(url, JSON_CONTENT_TYPE.toString(), json);
    }


    public static String post(String url, String contentType, String params) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(MediaType.parse(contentType), params);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public static String run(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void main(String[] args) throws Exception {

        FaceRequestVo faceRequestVo = new FaceRequestVo();
        File file = new File("d:/2.jpg");
        faceRequestVo.setImageBase64(FileBase64Util.encodeImageToBase64(file));

        String sign = SignUtil.sign(faceRequestVo, "KvJClhFHCsFAetO9");
        faceRequestVo.setSign(sign);
        String params = MapConvertUtil.convertMap2Str(MapConvertUtil.convertObject2Map(faceRequestVo));

        System.out.println(post("https://api.ai.qq.com/fcgi-bin/face/face_detectface", "application/x-www-form-urlencoded", params));

    }
}
