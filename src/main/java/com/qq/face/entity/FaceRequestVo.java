package com.qq.face.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

@Data
public class FaceRequestVo {

    /**
     * 应用标识
     */
    @JSONField(name = "app_id")
    private String appId = "1106885531";

    /**
     * 请求时间戳（秒级）
     */
    @JSONField(name = "time_stamp")
    private String timeStamp = System.currentTimeMillis() / 1000 + StringUtils.EMPTY;

    /**
     * 随机字符串
     */
    @JSONField(name = "nonce_str")
    private String nonceStr = RandomStringUtils.randomAlphabetic(10);

    /**
     * 签名信息
     */
    private String sign = StringUtils.EMPTY;

    /**
     * 待识别图片
     */
    @JSONField(name = "image")
    private String imageBase64;

    /**
     * 检测模式，0-正常，1-大脸模式（默认1）
     */
    private String mode = "1";

}
