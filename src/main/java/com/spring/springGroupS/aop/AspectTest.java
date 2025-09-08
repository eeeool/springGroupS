package com.spring.springGroupS.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Aspect
@Component
public class AspectTest {

	// 臾몄��1: getAopServiceTest1() 硫����� '��/��'�� 硫��몄�瑜� 異��ν������.
	@Around("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest1(..))")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("\n �닿납�� aroundAdvice() 硫����� ������. �듭�ш��ъ�� ������ ������. \n");
		
		joinPoint.proceed();
		
		System.out.println("\n �닿납�� aroundAdvice() 硫����� ������. �듭�ш��ъ�� ������ ������. \n");
	}
	
	// 臾몄��2: getAopServiceTest3() 硫����� '��'�� 硫��몄� 異��ν������.
	@Before("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest3(..))")
	public void beforeAdvice() {
		System.out.println("\n �닿납�� beforeAdvice() 硫����� ������. �듭�ш��ъ�� ������ ������. \n");
	}
 	
	// 臾몄��3: getAopServiceTest2() 硫����� ����寃곌낵 硫����������� 諛���媛��� 肄����� 異��ν������.
	@AfterReturning(value="execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest2(..))", returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		System.out.println("\n �닿납�� afterReturningAdvice() 硫����� ������. \n");
		System.out.println("   �듭�ъ������� 諛����� 媛�: " + result.toString() + "\n");
	}
	
	//臾몄��4 : getAopServiceTest2()硫������� getAopServiceTest3()硫�����媛� 媛�媛� ���������� 嫄몃━�� ��媛�?
	long startTime, endTime;
	@Pointcut("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest5*(..))")
// 	private void cut() {}
	
	@Around("cut()")
	public void arroundAdvice2(ProceedingJoinPoint joinPoint) throws Throwable {
		startTime = System.nanoTime();
		
		System.out.println("arroundAdvice2()硫�����������. (��) : " + joinPoint);
		joinPoint.proceed();
		System.out.println("arroundAdvice2()硫�����������. (��) : " + joinPoint);
		
		endTime = System.nanoTime();
		
		long res = endTime - startTime;
		System.out.println("������媛� : " + res);
	}

	
	// 臾몄��5: Study1service 媛�泥댁���� 紐⑤�� 硫������� ������媛��� �대�� 硫����� �대�怨� �④� 異���
	int cnt = 0;
	@Around("execution(* com.spring.springGroupS.service.Study1Service.*(..))")
	//@Around("execution(* com.spring.springGroupS.service..*.*(..))")
	public Object aroundAdvice5(ProceedingJoinPoint joinPoint) throws Throwable {
		cnt++;
		System.out.println(cnt + "踰�吏� : �닿납�� aroundAdvice5硫����� ������.");
		long startTime = System.nanoTime();
		try {
		  Object result = joinPoint.proceed();
		  return result;
		} finally {
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			System.out.println(cnt + "踰� 硫����� ������媛� : " + executionTime + "ns\n");
			System.out.println(cnt + "踰��� : ******************************************************\n");
		}
	}
}
		
