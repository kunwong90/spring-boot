package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @author kun.wang
 * @date 2018/9/18
 */
@Configuration
public class MultipartResolverConfigure {
    /**
     * 显示声明CommonsMultipartResolver为mutipartResolver
     * 如果不指定bean name，bean 的名字为方法名
     * @return
     */
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxInMemorySize(40960);
        //上传文件大小 10M 10*1024*1024
        resolver.setMaxUploadSize(10 * 1024 * 1024);
        return resolver;
    }
}
