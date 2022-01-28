package it.traning.eng.spring.config;

import it.traning.eng.spring.beans.DevBean;
import it.traning.eng.spring.beans.MyBeanExternal;
import it.traning.eng.spring.beans.MyBeanInterface;
import it.traning.eng.spring.beans.OtherBeanInterface;
import org.springframework.context.annotation.*;



@Configuration
@ComponentScan({"it.traning.eng.spring","it.traning.eng.spring.config","it.traning.eng.spring.beans"})
@PropertySource("classpath:config.properties")
@Profile({"develop"})
public class DevConfiguration {

    @Bean(initMethod = "init")
    public MyBeanInterface myBean(){ // attenzione il nome del bean
        System.out.println("<<<<< "+this.getClass().getName()+" myBean >>>>>");

        return new DevBean();
    }

    @Bean(initMethod = "init")
    public OtherBeanInterface myBeanTwo(){ // attenzione il nome del bean
        System.out.println("<<<<< "+this.getClass().getName()+" myBeanTwo >>>>>");
        return new OtherBeanInterface(){
            @Override
            public void afterPropertiesSet() throws Exception {
                System.out.println("<<<<< "+this.getClass().getName()+" afterPropertiesSet >>>>>");
            }

            @Override
            public void otherStuff() {
                System.out.println("<<<<< "+this.getClass().getName()+" otherStuff >>>>>");
            }

            @Override
            public void init() {
                System.out.println("<<<<< "+this.getClass().getName()+" init >>>>>");
            }
        };
    }


}
