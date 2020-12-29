package com.test.demo.config.mybatis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
// 放入spring 容器
public class VerificationAspect {

    private final static Logger logger = LoggerFactory.getLogger(VerificationAspect.class);

    //拦截条件
    @Pointcut("execution(public * com.test.demo.controller.HelloController.*(..))")
    public void log() {}
    @Around("log()")
    public Object signVerification(ProceedingJoinPoint pjp) throws Throwable{
        //已经登录
        if (true) {
            return pjp.proceed();//继续执行被拦截的方法
        }
        //未登录
        else {
            //构建JSON
            String response = "{'signin':0}";
            return response;
        }
    }

    // 登录验证
    public boolean Verification(){
        ServletRequestAttributes attributes =   (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session= request.getSession();
        if (session.getAttribute("Admin") == null){
            return false;
        }
        return true;
    }
}
