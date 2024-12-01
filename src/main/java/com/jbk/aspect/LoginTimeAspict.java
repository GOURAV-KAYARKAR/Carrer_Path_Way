package com.jbk.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class LoginTimeAspict {
	
@Around("execution(* com.jbk.controller.UserController.createUser(..))" )
	public Object trackExecutionTime (ProceedingJoinPoint joinPoint  ) throws Throwable {
//	Logger logger = LoggerFactory.getlogger(LoginTimeAspict.class);
			Logger logger = LoggerFactory.getLogger(LoginTimeAspict.class);
		long startTime =System.currentTimeMillis();
		Object obj = joinPoint.proceed();
		long endTime =System.currentTimeMillis();
 
		logger.info("Execution time =" +(endTime-startTime));
		return obj;
	}
	
}
