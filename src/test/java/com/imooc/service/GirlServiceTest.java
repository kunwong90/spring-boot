package com.imooc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.imooc.mapper")
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void getAge() throws Exception {
        girlService.getAge(1);
    }
}