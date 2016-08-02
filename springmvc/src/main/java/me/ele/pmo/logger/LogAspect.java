package me.ele.pmo.logger;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by kimi on 7/19/16.
 */
@Component
@Aspect
public class LogAspect {
    private Logger logger = Logger.getLogger(LogAspect.class);

    @Before("execution(* me.ele.pmo.service.*.*(..))")
    public void before(JoinPoint joinPoint) {
        /*if (joinPoint != null) {
            Object[] args = joinPoint.getArgs();

            if (args != null) {
                Department d = (Department) args[0];
                logger.info(d.getDepartmentId());
                logger.info(d.getDepartmentName());
                logger.info(d.getDepartmentManager());
                logger.info(d.getProjectManager());
            }
        }*/

        logger.info("----------before----------");
    }

    /*
    @Around("execution(* me.ele.pmo.service.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    }*/

    @After("execution(* me.ele.pmo.service.*.*(..))")
    public void after() {
        logger.info("----------after----------");
    }
}
