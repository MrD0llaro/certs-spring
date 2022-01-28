package it.traning.eng.spring;

import it.traning.eng.spring.beans.MyBeanInterface;
import it.traning.eng.spring.beans.OtherBeanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {

    @Autowired
    public MyBeanInterface myBean;

     @Autowired
    @Qualifier("myBeanTwo")
    public OtherBeanInterface myBeanTwo;


    public static void main(String[] args) {
        // appication context
        System.out.println("<<<<< " + App.class.getName() + "  STARTING >>>>>");
        ApplicationContext ctx = new AnnotationConfigApplicationContext("it.traning.eng.spring", "it.traning.eng.spring.config");
        final App bean = ctx.getBean(App.class);
        bean.start(args);
        ((AnnotationConfigApplicationContext) ctx).close();

        System.out.println("<<<<< ALL MY BEAN [profiles - " + getStringFromArray(ctx.getEnvironment().getActiveProfiles()) + "] >>>>>");
        printArrays(((AnnotationConfigApplicationContext)ctx).getBeanFactory().getBeanDefinitionNames());
        System.out.println("<<<<< " + App.class.getName() + "  FINISH >>>>>");

    }

    private static void printArrays(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }

    private static String getStringFromArray(String[] array) {
        String out = null;
        for (String s : array) {
            if (out == null ) out = s;
            else
            out = out +","+ s;
        }
        return out;
    }

    public void start(String[] args) {
        System.out.println("<<<<< "+App.class.getName()+"  START >>>>>");
        myBean.execute();
    }
}
