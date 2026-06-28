package org.example.firstspringproject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {

    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint joinPoint){
        long start = System.currentTimeMillis();

        try{

            joinPoint.proceed();

        } catch(Throwable t) {
            System.out.println("Something went wrong during execution");

        }finally{
            long end = System.currentTimeMillis();
            long ExecutionTime = end - start;
            System.out.println("total execution time is : " + ExecutionTime + " ms..");
        }


    }
}
