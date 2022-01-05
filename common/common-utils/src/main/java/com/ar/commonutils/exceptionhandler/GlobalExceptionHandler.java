package com.ar.commonutils.exceptionhandler;

import com.ar.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        //log.error(e.getMessage());
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}