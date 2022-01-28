package it.traning.eng.spring.beans;

import org.springframework.beans.factory.InitializingBean;

public class MyInitializingBean implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("<<<<< "+this.getClass().getName()+"   afterPropertiesSet  >>>>");

    }
}
