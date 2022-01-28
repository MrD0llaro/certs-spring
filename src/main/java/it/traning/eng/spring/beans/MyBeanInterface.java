package it.traning.eng.spring.beans;

import org.springframework.beans.factory.InitializingBean;

public interface MyBeanInterface extends InitializingBean {
    int DEFALT_MAX  =200;
    void execute();

    void init();
}
