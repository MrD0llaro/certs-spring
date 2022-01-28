package it.traning.eng.spring.config;

import it.traning.eng.spring.beans.DevBean;
import it.traning.eng.spring.beans.MyBeanExternal;
import it.traning.eng.spring.beans.MyBeanInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;



@Configuration
@ComponentScan("it.traning.eng.spring")
@PropertySource("classpath:config.properties")
@Profile("develop")
public class DevConfiguration {

    @Bean
    public MyBeanInterface myBean(){ // attenzione il nome del bean
        return new DevBean();
    }

    @Bean(initMethod = "init",name = "myBeanTwo")

    public MyBeanInterface myBeanTwo(){ // attenzione il nome del bean
        return new DevBean();
    }
}
