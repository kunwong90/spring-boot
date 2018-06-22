package com.springmvc;

import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof ParamException) {
            ParamException paramException = (ParamException) e;
            return ResultUtil.error(paramException.getCode(), paramException.getMessage());
        } else {
            LOGGER.error("系统异常 = {}", e);
            return ResultUtil.error(-1, "未知错误");
        }

    }
}