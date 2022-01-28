package it.traning.eng.spring.config;

import it.traning.eng.spring.beans.MyBeanExternal;
import it.traning.eng.spring.beans.MyBeanInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("it.traning.eng.spring")
@PropertySource("classpath:config.properties")
@Profile("!develop")
public class MyConfiguration {

    @Bean
    public MyBeanInterface myBean(){ // attenzione il nome del bean
        return new MyBeanExternal();
    }

    @Bean()
    @Qualifier("pippo")
    public MyBeanInterface myBeanTwo(){ // attenzione il nome del bean
        return new MyBeanExternal();
    }
}
