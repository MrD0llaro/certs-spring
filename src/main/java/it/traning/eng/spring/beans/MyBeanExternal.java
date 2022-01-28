package it.traning.eng.spring.beans;

import org.springframework.beans.factory.annotation.Value;

// Coponent  per libreies estene ...
public class MyBeanExternal implements MyBeanInterface {

     @Value(value = "${current.max}")
     private int max;


     public void afterPropertiesSet() throws Exception {

         System.out.println("<<<<< "+this.getClass().getName()+"   afterPropertiesSet init >>>>");

     }
    public void init(){
        System.out.println("<<<<< "+this.getClass().getName()+"  init >>>>");
    }
    public void execute() {
        System.out.println("<<<<< "+this.getClass().getName()+"  execute method "+max+"  >>>>");
    }
}
