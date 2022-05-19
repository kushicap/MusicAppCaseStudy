package com.cg.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.aop.LoggingAdvice;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggingAdvice {
	Logger log =  LoggerFactory.getLogger(LoggingAdvice.class);
	@Pointcut(value="execution(* com.cg.*.*.*(..) )")
	public void mypointcut() {
		
	}
	@Around("mypointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper=new ObjectMapper();
		String methodName=pjp.getSignature().getName();
	 	String className=pjp.getTarget().getClass().toString();
		Object[] array=pjp.getArgs();
		log.info("method invoked" + className + " :" + methodName + "()" + "arguments :" + mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		log.info(className + " :" + methodName + "()" + "Response :" + mapper.writeValueAsString(object));
		return object;
		
	}

}