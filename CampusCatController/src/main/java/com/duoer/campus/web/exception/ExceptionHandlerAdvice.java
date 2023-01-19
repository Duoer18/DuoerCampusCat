package com.duoer.campus.web.exception;

import com.duoer.campus.entity.User;
import com.duoer.campus.exception.BusinessException;
import com.duoer.campus.exception.SystemException;
import com.duoer.campus.web.format.ResponseCode;
import com.duoer.campus.web.format.Result;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestCookieException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(SystemException.class)
    public Result sysHandle(SystemException e) {
        // notify the exception
        e.printStackTrace();
        return new Result(e.getCode(), null, e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result busHandle(BusinessException e) {
        return new Result(e.getCode(), null, e.getMessage());
    }

    /**
     * 参数类型不匹配异常、请求体缺失异常，采用与业务异常相似的处理，提示用户输入正确的参数
     *
     * @return Result对象
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    public Result argMismatch() {
        return new Result(ResponseCode.BUSINESS_ERR.getCode(), null, "请给出正确参数！");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result noSupportMethod() {
        return new Result(ResponseCode.BUSINESS_ERR.getCode(), null, "错误的请求方式！");
    }

    @ExceptionHandler(MissingRequestCookieException.class)
    public Result missingCookie() {
        User u = new User();
        u.setUsername("");
        u.setPassword("");
        return new Result(ResponseCode.GET_SUC.getCode(), u);
    }

    @ExceptionHandler(SQLException.class)
    public Result sqlException() {
        return new Result(ResponseCode.SYSTEM_ERR.getCode(), null, "系统繁忙，请稍后！");
    }

    @ExceptionHandler(Exception.class)
    public Result handle(Exception e) {
        e.printStackTrace();
        return new Result(ResponseCode.ERR.getCode(), null, "未知的错误！");
    }
}
