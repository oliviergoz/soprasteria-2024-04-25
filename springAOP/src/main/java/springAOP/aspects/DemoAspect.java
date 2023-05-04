package springAOP.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspect {

	@Pointcut("execution( * springAOP.beans.*.methode(..))")
	public void pointcut() {

	}

	@Pointcut("execution( * springAOP.beans.AutreBean.methode(..))")
	public void pointcutAutreBean() {

	}

	@Before("pointcut()")
	public void before(JoinPoint jp) {
		System.out.println("methode before:" + jp.getTarget());
	}

	@After("pointcutAutreBean()")
	public void after() {
		System.out.println("methode after");
	}

	@AfterReturning(pointcut = "pointcut()", returning = "nomVariable")
	public void afterReturning(String nomVariable) {
		System.out.println("methode afterReturning (succes),valeur recu:" + nomVariable);
	}

	@AfterThrowing("pointcut()")
	public void afterThrowing() {
		System.out.println("exception");
	}

	@Around("pointcut()")
	public String around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("methode around, je lance la methode interceptee");
		String s = (String) pjp.proceed();
		System.out.println("la valeur recu par l'execution:" + s + "\n mais je vais la changer");
		return "around";
	}
}
