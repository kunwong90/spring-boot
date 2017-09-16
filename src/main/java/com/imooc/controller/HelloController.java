package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangkun on 2016/12/15.
 */

@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @Value("${content}")
    private String content;

    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    public String say() {
        return girlProperties.getCupSize();
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String say1() {
        return content;
    }
}
