package com.example.demo.aop;

import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Aspect
@Component("controllerLogAspect")
public class ControllerLogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspect.class);

//    @Around(value = "execution(* com.example.demo..controller..*.*(..))")
@Around("execution(* com.example.demo.controller.UserController.*(..))")
public void recordControllerLog(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("----------------ASPECT START--------------");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra == null ? null : sra.getRequest();

        StringBuilder logMsg = new StringBuilder();
        logMsg.append(request == null ? null : request.getRequestURI());
        logMsg.append(pjp.getTarget().getClass());
        logMsg.append(pjp.getSignature().getName());
        logMsg.append(Arrays.toString(pjp.getArgs()));

        String url = request == null ? null : request.getRequestURI();
        String accessMethod = request == null ? null : request.getMethod();
        String clazzName = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();
        LOGGER.info("url: {}", url);
        LOGGER.info("class: {}", clazzName);
        LOGGER.info("method: {}", methodName);
        LOGGER.info("args: {}", args);
        LOGGER.info("access method: {}", accessMethod);
        // LOGGER.info("user delete id: {}", id);

        pjp.proceed();

        System.out.println("----------------ASPECT FINISH--------------");
}

}
