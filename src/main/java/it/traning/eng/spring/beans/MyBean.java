package it.traning.eng.spring.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component()
public class MyBean implements MyBeanInterface {

    @Value(value = "${current.max}")
    private int max;
    public void execute() {
        System.out.println("<<<<< "+this.getClass().getName()+" "+max+" >>>>>");
    }

    @Override
    public void init() {
        System.out.println("<<<<< "+this.getClass().getName()+" init >>>>>");
    }

  @PreDestroy
  public void preDestroy() {

      System.out.println("<<<<< "+this.getClass().getName()+" PreDestroy >>>>>");
  }


    public void afterPropertiesSet() throws Exception {
        System.out.println("<<<<< "+this.getClass().getName()+"   afterPropertiesSet init >>>>>");
    }
}
