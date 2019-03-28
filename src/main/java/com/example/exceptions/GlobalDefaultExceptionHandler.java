package com.example.exceptions;

import com.example.entity.Response;
import com.example.exceptions.exception.LxInterfaceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author eddie
 * @createTime 2018-12-01
 * @description 全局异常处理类
 */
@RestControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response defaultExceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof LxInterfaceException){
            return new Response(e);
        }
        return new Response(e);
    }

}
