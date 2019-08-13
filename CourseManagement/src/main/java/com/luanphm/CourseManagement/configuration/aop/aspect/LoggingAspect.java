package com.luanphm.CourseManagement.configuration.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger("CUSTOM LOGGING");

    private String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = null;
        try {
            currentPrincipalName = authentication.getName();
        } catch (NullPointerException e) {
            currentPrincipalName = "anonymous";
        }
        return currentPrincipalName;
    }

    private String generateLog(String methodSignature, String exception) {
        if (exception != null) {
            return getCurrentUser() +": " + methodSignature + "| FAIL "  + " | " + exception;
        } else {
            return getCurrentUser() +": " + methodSignature + "| SUCCESS";
        }
    }

    @Before("execution(* com.luanphm.CourseManagement.service.*Impl.*(..))")
    public void beforeAccessRepository(JoinPoint theJoinPoint) {
        logger.info(getCurrentUser() +": " + theJoinPoint.getSignature().toShortString());
    }

    @AfterReturning("execution(* com.luanphm.CourseManagement.service.*.add(..))")
    public void afterAddSuccess(JoinPoint theJoinPoint) {
        logger.info(generateLog(theJoinPoint.getSignature().toShortString(), null));
    }

    @AfterThrowing(value = "execution(* com.luanphm.CourseManagement.service.*.add(..))", throwing = "exception")
    public void afterAddFail(JoinPoint theJoinPoint, Throwable exception) {
        logger.error(generateLog(theJoinPoint.getSignature().toShortString(),  exception.getMessage()));
    }

    @After("execution(* com.luanphm.CourseManagement.service.*.update(..))")
    public void afterUpdateSuccess(JoinPoint theJoinPoint) {
        logger.info(generateLog(theJoinPoint.getSignature().toShortString(), null));
    }

    @AfterThrowing(value = "execution(* com.luanphm.CourseManagement.service.*.update(..))", throwing = "exception")
    public void afterUpdateFail(JoinPoint theJoinPoint, Throwable exception) {
        logger.error(generateLog(theJoinPoint.getSignature().toShortString(), exception.getMessage()));
    }

    @After("execution(* com.luanphm.CourseManagement.service.*.delete*(..))")
    public void afterDeleteSuccess(JoinPoint theJoinPoint) {
        logger.info(generateLog(theJoinPoint.getSignature().toShortString(), null));
    }

    @AfterThrowing(value = "execution(* com.luanphm.CourseManagement.service.*.delete*(..))", throwing = "exception")
    public void afterDeleteFail(JoinPoint theJoinPoint, Throwable exception) {
        logger.error(generateLog(theJoinPoint.getSignature().toShortString(), exception.getMessage()));
    }
}
