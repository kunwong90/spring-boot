package com.qq.face.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Base64;

public class FileBase64Util {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileBase64Util.class);

    public static String encodeImageToBase64(File file) throws Exception {
        LOGGER.info("file path = " + file.getPath());
        byte[] bytes = FileUtils.readFileToByteArray(file);
        return new String(Base64.getEncoder().encode(bytes), "utf-8");
    }
}
