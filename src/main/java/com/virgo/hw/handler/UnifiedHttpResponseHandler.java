package com.virgo.hw.handler;

import com.google.common.collect.ImmutableList;
import com.virgo.hw.bean.anno.CustomResponseAdvice;
import com.virgo.hw.bean.commom.Resp;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * @author wangchenkai
 * @since 2020/6/28 5:33 下午
 */
@ControllerAdvice(annotations = {RestController.class, ResponseBody.class})
@Slf4j
@NoArgsConstructor
public class UnifiedHttpResponseHandler implements ResponseBodyAdvice {

    private static final ImmutableList<Class<? extends Annotation>> REQUEST_ANNOTATIONS = ImmutableList.of(RequestMapping.class, GetMapping.class, PostMapping.class, PutMapping.class, DeleteMapping.class, PatchMapping.class);

    private static final Class<? extends Annotation> CUSTOM_RESPONSE_ADVICE = CustomResponseAdvice.class;

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        AnnotatedElement element = returnType.getAnnotatedElement();
        return REQUEST_ANNOTATIONS.stream().anyMatch(annotation -> annotation.isAnnotation() && element.isAnnotationPresent(annotation) && !element.isAnnotationPresent(CUSTOM_RESPONSE_ADVICE));
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        return Resp.ok(body);
    }
}
