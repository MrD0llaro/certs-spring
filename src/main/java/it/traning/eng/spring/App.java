package it.traning.eng.spring;

import it.traning.eng.spring.beans.MyBeanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Indexed;

@Component

public class App {

    @Autowired
    public MyBeanInterface myBean;

    @Autowired
    public MyBeanInterface myBeanTwo;

    //@Autowired
    //@Qualifier("pippo")
    //public MyBeanInterface anotherName;

    public static void main(String[] args){
       // appication context
        System.out.println("<<<<< "+App.class.getName()+"  STARTING >>>>>");
        ApplicationContext  ctx  = new AnnotationConfigApplicationContext("it.traning.eng.spring" );

        final App bean = ctx.getBean(App.class);
        bean.start(args);
        ((AnnotationConfigApplicationContext)ctx).close();

        System.out.println("<<<<< "+App.class.getName()+"  FINISH >>>>>");

    }

    public void start(String[] args) {
        System.out.println("<<<<< "+App.class.getName()+"  START >>>>>");
        myBean.execute();
    }
}
