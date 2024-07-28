package com.example.demo.aop;

import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect

public class ControllerLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);

//    @Around(value = "execution(* com.example.demo..controller..*.*(..))")
@Around("execution(* com.example.demo.controller.UserController.*(..))")
public void recordControllerLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("----------------ASPECT START--------------");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra == null ? null : sra.getRequest();
        String url = request == null ? null : request.getRequestURI();
        String clazz = pjp.getTarget().getClass().toString();
        String method = request.getMethod();
        System.out.println(url);
        System.out.println(clazz);
        System.out.println(method);
        LOGGER.info("url: {}", url);
        // LOGGER.info("user delete id: {}", id);
        pjp.proceed();
        System.out.println("----------------ASPECT FINISH--------------");
}

}
