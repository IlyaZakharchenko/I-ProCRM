package ru.kpfu.itis.app.model.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class Logger {
    private final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass());

    @Before("execution(* ru.kpfu.itis.app.*.*.*(..))()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("Вызов метода: " + joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "execution(* ru.kpfu.itis.app.*.*.*(..))()", throwing = "exception")
    public void afterAdvice(JoinPoint joinPoint, ClassCastException exception) {
        log.error("Найдено исключение " + exception.toString());
    }
}
