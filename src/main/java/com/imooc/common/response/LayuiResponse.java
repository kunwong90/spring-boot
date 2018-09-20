package com.imooc.common.response;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author kun.wang
 * @date 2018/9/20
 */
public class LayuiResponse<T> {
    private Integer code;
    private String msg;
    private Integer count;

    private List<T> data;

    public LayuiResponse(Integer code, String msg, List<T> data, Integer count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public LayuiResponse(List<T> data, Integer count) {
        this(0, StringUtils.EMPTY, data, count);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "LayuiResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
