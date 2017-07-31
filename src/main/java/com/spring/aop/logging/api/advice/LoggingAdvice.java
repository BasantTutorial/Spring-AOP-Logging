package com.spring.aop.logging.api.advice;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAdvice {

	Logger logger = Logger.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.spring.aop.logging.api.controller.UserController.*(..))")
	public void myPointcut() {

	}

	@Around(value = "myPointcut()")
	public Object log(ProceedingJoinPoint pjp) {
		String log4jConfigFile = System.getProperty("user.dir")
				+ File.separator + "log4j.xml";
		DOMConfigurator.configure(log4jConfigFile);

		Object obj = null;
		ObjectMapper mapper = new ObjectMapper();
		String resp = "";
		try {
			String methodName = pjp.getSignature().getName();
			Object[] args = pjp.getArgs();
			logger.info(methodName + " method call start..with argument :"
					+ mapper.writeValueAsString(args));
			obj = pjp.proceed();
			resp = mapper.writeValueAsString(obj);
			System.out.println(resp);
			logger.info("After Execution method return s " + resp);
			logger.info(methodName + " method call end");
		} catch (Throwable e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}
}
