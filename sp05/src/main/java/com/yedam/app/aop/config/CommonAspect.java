package com.yedam.app.aop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // AOP의 설정
//@Component
public class CommonAspect {
	// 포인트컷 : 조인포인트 중에서 Advice가 적용될 메소드 필터
	@Pointcut("execution(* *com.yedam.app..*Impl.*(..))") //execution : 메소드 기준
	// (* ) : 리턴타입이 노상관
	// *(..) : 메소드 전체
	// *Impl. : 메소드는 혼자 존재할 수 없고, 클래스가 필요해서 클래스 추가 -> com.yedam.app이라는 패키지로 시작해서 .Impl로 끝나는 클래스 전체 풀네임을 찾음
	// *com.yedam.app.. : 클래스도 무조건 패키지안에 있어야해서 패키지 추가 (패키지 전체 풀네임을 찾음)
	public void allPointcut() {};
	
	//Weaving : 포인트컷 + 타이밍 + Advice(실제 공통코드 실행하는 시점) => 몰라도되긴한데 쓰이고있어서 알아두면 좋음
	//비포랑 애프터는 모양이 같은데 어라운드만 다름
	@Before("allPointcut()") //로직 시작전에 진행
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName(); //시그니처 안에서 이름을 찾기
		String keyword = (String) jp.getArgs()[0]; //어떤 데이터가 올지 몰라서 객체(배열)로 받아야하고, 무조건 강제 타입변환해야함
		System.out.println("[사전처리] beforeLog : " + methodName);
		System.out.println("[사전처리] beforeLog : " + keyword);
	}
	
	@Around("allPointcut()")
	//무조건 리턴타입을 Object로 해야함
	public Object aroundLog(ProceedingJoinPoint jp) throws Throwable {
		String signaterStr = jp.getSignature().toString();
		
		System.out.println("=== 시작 : " + signaterStr);
		try {
			Object obj = jp.proceed(); //조인포인트에있는 모든 리턴타입을 받으려고 사용
			//어라운드는 앞뒤에 우리 코드를 추가해서 실행하는거라 스프링 스스로 실행안하기 때문에 우리가 스스로 실행해서 스프링에 돌려준다?
			//소요시간을 보여줌?
			System.out.println("=== 결과 : " + (Integer)obj);
			return obj;
		}finally {
			System.out.println("=== 끝 : " + signaterStr);
			//앞뒤로 실행되기 때문에 어지간하면 트라이캐치 이용해서 finally 넣음
		}
	}
}
