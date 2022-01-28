package it.traning.eng.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AOPBean {
    @Autowired
    AOPBean self;

    public int sum(int a, int b){
        return a+b;
    }
    @MyAudit
    public int sub(int a, int b) {
        return a-b;
    }



    @Cacheable(value = "default")
    public String myVeryLongOperation(String salt){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }
    // self invocation example
    // bad not working annotations like Cache
    public String test(String salt){
        return myVeryLongOperation(salt);
    }


    // self invocation example  SOLUTION
    public String testCorrect(String salt){
        return self.myVeryLongOperation(salt);
    }
}
