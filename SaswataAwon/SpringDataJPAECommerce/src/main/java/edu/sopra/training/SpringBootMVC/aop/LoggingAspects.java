package edu.sopra.training.SpringBootMVC.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.sopra.training.SpringBootMVC.services.Create;

@Aspect
@Component
public class LoggingAspects {

	private static final Logger LOG= LoggerFactory.getLogger(Create.class);
	
//	@Around("execution(* edu.sopra.training.SpringBootMVC.services.Create.addProduct(..)) && args(pname,pdesc,pprice,qty)")
//	public Object productBeforeLogging(ProceedingJoinPoint jp, String pname,String pdesc,int pprice,int qty) throws Throwable {
//		
//		if(pname!=null) {
//			
//			LOG.info("Before adding the product " + jp.getSignature().getName() );
//			pname="Karthi";
//		}
//		
//		return jp.proceed(new Object[] {pname,pdesc,pprice,qty});
//		
//		 
//	}
	
	@Around("execution(* edu.sopra.training.SpringBootMVC.services.Create.addProduct(..)) || execution(* edu.sopra.training.SpringBootMVC.services.Create.search(..))")
	public Object productAfterLogging(ProceedingJoinPoint jp) throws Throwable {
		
		String cName = jp.getSignature().getName();
		Object obj=null;
		switch (cName) {
		case "addProduct": long addStart = System.currentTimeMillis(); 
							obj = jp.proceed(); 
							long addEnd = System.currentTimeMillis(); 
							LOG.info("Time taken to execute Add Product "+ (addEnd-addStart) +" ms");
							break;
		case "search" : long searchStart = System.currentTimeMillis(); 
						obj = jp.proceed(); 
						long searchEnd = System.currentTimeMillis(); 
						LOG.info("Time taken to execute Search Product "+ (searchEnd-searchStart)+ " ms");
						break;
		}
		
		return obj;
	}
//	
//	@AfterThrowing("execution(* edu.sopra.training.SpringBootMVC.services.Create.*(..))")
//	public void productAfterThrowingLogging() {
//		
//		LOG.info("After throwing and adding the product");
//	}
//	
//	@AfterReturning("execution(* edu.sopra.training.SpringBootMVC.services.Create.addProduct(..))")
//	public void productAfterReturningLogging() {
//		
//		LOG.info("After returning and adding the product");
//	}
}
