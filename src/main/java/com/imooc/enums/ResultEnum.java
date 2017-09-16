package com.imooc.enums;

public enum ResultEnum {

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学吧"),
    MIDDLE_SCHOOL(101, "你可能还在上初中");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String meg) {
        this.code = code;
        this.msg = meg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
