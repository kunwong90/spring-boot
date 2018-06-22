package com.springmvc;

public class ParamException extends RuntimeException {
    private Integer code;

    private String message;

    public ParamException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
