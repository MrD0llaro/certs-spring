package it.traning.eng.spring.beans;

public class DevBean implements MyBeanInterface {
    @Override
    public void execute() {
        System.out.println("<<<<< DevBean execute method >>>>");

    }

    @Override
    public void init() {
        System.out.println("<<<<< init >>>>");
    }

    public void afterPropertiesSet() throws Exception {

        System.out.println("<<<<< DevBean  afterPropertiesSet init >>>>");

    }
}
