package com.duoer.campus.web.exception;

import com.duoer.campus.exception.BusinessException;
import com.duoer.campus.exception.SystemException;
import com.duoer.campus.web.format.ResponseCode;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

/**
 * 执行表现层和业务层方法时，捕获异常并重新封装
 *
 * @author duoer
 */
@Component
@Aspect
public class PackagingExceptionAdvice {
    /**
     * 为所有表现层方法做增强
     */
    @Pointcut("execution(* com.duoer.campus.web.*Controller.*(..))")
    private void controllerPt() {
    }

    /**
     * 捕获表现层异常，将调用业务层时封装好的系统异常和业务异常直接抛出，其余异常一律封装为系统异常
     *
     * @param proceedingJoinPoint 执行原方法
     * @return Result对象
     */
    @Around("controllerPt()")
    public Object catchControllerException(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch (SystemException | BusinessException e) {
            throw e;
        } catch (Throwable e) {
            throw new SystemException(ResponseCode.SYSTEM_ERR.getCode(), "系统繁忙，请稍后！", e);
        }
    }

    /**
     * 为所有业务层方法做增强
     */
    @Pointcut("execution(* com.duoer.campus.service.*Service.*(..))")
    private void servicePt() {
    }

    /**
     * 捕获业务层异常，将数据完整性异常封装为业务异常（用户提供错误参数或未提供必要参数），其余异常一律封装为系统异常
     *
     * @param proceedingJoinPoint 执行原方法
     * @return Result对象
     */
    @Around("servicePt()")
    public Object catchServiceException(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch (DataIntegrityViolationException e) {
            throw new BusinessException(ResponseCode.BUSINESS_ERR.getCode(), "请给出正确参数！", e);
        } catch (Throwable e) {
            throw new SystemException(ResponseCode.SYSTEM_ERR.getCode(), "系统繁忙，请稍后！", e);
        }
    }
}
