package com.seven.forum.config;

import com.seven.forum.vo.ResponseVO;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandlerConfiguration {
    //全局异常处理
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseVO<String> handleException(Throwable e){
        ResponseVO responseVO = new ResponseVO(500,e.getMessage(),null);
        return responseVO;
    }
}
