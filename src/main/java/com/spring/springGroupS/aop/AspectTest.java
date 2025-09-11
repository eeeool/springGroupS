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

	// 문제1: getAopServiceTest1() 메서드의 '전/후'에 로그를 출력하시오.
	@Around("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest1(..))")
	public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("\n 이곳은 aroundAdvice() 메서드 실행 전입니다. 업무가 실행될 예정입니다. \n");
		
		joinPoint.proceed();
		
		System.out.println("\n 이곳은 aroundAdvice() 메서드 실행 후입니다. 업무가 완료되었습니다. \\n");
	}
	
	// 문제2: getAopServiceTest3() 메서드의 '전'에 로그를 출력하시오.
	@Before("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest3(..))")
	public void beforeAdvice() {
		System.out.println("\\n 이곳은 beforeAdvice() 메서드 실행 전입니다. 업무가 시작될 예정입니다. \n");
	}
 	
	// 문제3: getAopServiceTest2() 메서드의 실행결과를 실행 후에 반환값을 콘솔에 출력하시오.
	@AfterReturning(value="execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest2(..))", returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
		System.out.println("\n 이곳은 afterReturningAdvice() 메서드 실행 후입니다. \n");
		System.out.println("   결과적으로 반환받은 값: " + result.toString() + "\n");
	}
	
	// 문제4: getAopServiceTest2()메서드와 getAopServiceTest3()메서드가 같이 걸리게 할수 있나?
	long startTime, endTime;
	@Pointcut("execution(* com.spring.springGroupS.service.Study1Service.getAopServiceTest5*(..))")
// 	private void cut() {}
	
	@Around("cut()")
	public void arroundAdvice2(ProceedingJoinPoint joinPoint) throws Throwable {
		startTime = System.nanoTime();
		
		System.out.println("arroundAdvice2()메소드 실행 전. (전): " + joinPoint);
		joinPoint.proceed();
		System.out.println("arroundAdvice2()메소드 실행 후. (후): " + joinPoint);
		
		endTime = System.nanoTime();
		
		long res = endTime - startTime;
		System.out.println("소요시간: " + res);
	}

	
	// 문제5: Study1Service 객체의 모든 메서드의 실행시간을 구해 로그에 찍고 출력
	int cnt = 0;
	@Around("execution(* com.spring.springGroupS.service.Study1Service.*(..))")
	//@Around("execution(* com.spring.springGroupS.service..*.*(..))")
	public Object aroundAdvice5(ProceedingJoinPoint joinPoint) throws Throwable {
		cnt++;
		System.out.println(cnt + "번째: 이곳은 aroundAdvice5메서드 실행.");
		long startTime = System.nanoTime();
		try {
		  Object result = joinPoint.proceed();
		  return result;
		} finally {
			long endTime = System.nanoTime();
			long executionTime = endTime - startTime;
			System.out.println(cnt + "번째 메서드 실행시간: " + executionTime + "ns\n");
			System.out.println(cnt + "번째 : ******************************************************\n");
		}
	}
}
		
