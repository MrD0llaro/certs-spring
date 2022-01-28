package it.traning.eng.spring.beans;

import org.springframework.beans.factory.InitializingBean;

public interface OtherBeanInterface extends InitializingBean {
    int DEFALT_MAX  =200;
    void otherStuff();
    void init();
}
