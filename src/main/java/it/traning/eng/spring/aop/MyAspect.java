package it.traning.eng.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    //@Pointcut("execution(int it.traning.eng.spring.aop.AOPBean.sum(..))")
   // @Pointcut("execution(int it.traning.eng.spring.aop.AOPBean.*(..))")
    @Pointcut("execution(* it.traning.eng.spring.*.*.*(..))")
    public void myPointcut() throws Throwable {
    }

    @Pointcut("@annotation(it.traning.eng.spring.aop.MyAudit)")
    public void myPointcutAnnotation() throws Throwable {
    }




    // ASPECT BEFORE
    @Before("myPointcutAnnotation()")
    public void beforeAdvice(JoinPoint jp) throws Throwable {
        System.out.println("[<<< beforeAdvice >>>]");
        System.out.println("Invooking method:" + jp.getSignature());
        for (Object arg : jp.getArgs()) {
            System.out.println("-rgs:" + arg);
        }

    }



    // ASPECT AFTER
    @Around("myPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[<<< afterAdvice >>>]");
        System.out.println("Invooking method:" + pjp.getSignature());
    Object[] args  = pjp.getArgs();
    Object ret  = pjp.proceed(args);
    return ret;
    }


    // ASPECT AFTER
    @After("myPointcut()")
    public void afterAdvice(JoinPoint jp) throws Throwable {
        System.out.println("[<<< afterAdvice >>>]");
        System.out.println("Invooking method:" + jp.getSignature());
    }



}
