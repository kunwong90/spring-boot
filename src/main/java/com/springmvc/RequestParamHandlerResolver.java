package com.springmvc;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.nio.charset.Charset;

public class RequestParamHandlerResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(RequestParam.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        // 获取注解对象
        RequestParam requestParam = parameter.getParameterAnnotation(RequestParam.class);
        if (requestParam.contentType().equals(ContentTypeEnum.JSON)) {
            ServletServerHttpRequest servletServerHttpRequest = new ServletServerHttpRequest(
                    webRequest.getNativeRequest(HttpServletRequest.class));
            MediaType mediaType = servletServerHttpRequest.getHeaders().getContentType();
            Charset charset = mediaType != null ? mediaType.getCharset() : Charset.forName("UTF-8");
            // 获取请求数据
            String requestBody = FileCopyUtils
                    .copyToString(new InputStreamReader(servletServerHttpRequest.getBody(), charset));

            // 获取请求参数MbfBody
            Object paramObj = JSON.parseObject(requestBody, requestParam.type());

            // 校验入参
            if (requestParam.validate()) {

            }

            return paramObj;
        } else {
            HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
            String parameterName = requestParam.name();
            Class<?> clazz = requestParam.type();

            String parameterValue = request.getParameter(parameterName);
            if (requestParam.required()) {
                if (org.apache.commons.lang3.StringUtils.isBlank(parameterValue)) {
                    throw new ParamException(201, parameterName + "不能为空!");
                }
            }
            return parseValue(parameterValue, clazz);
        }

    }

    /**
     * 把val转换成type类型返回 parseValue("123",Integer.class) 返回一个123
     * @param val
     * @param type
     * @param <T>
     * @return
     */
    public <T> T parseValue(String val, Class<T> type) {
        T value = null;
        try {
            Constructor<T> constructor = type.getConstructor(String.class);
            constructor.setAccessible(true);
            value = constructor.newInstance(val);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
