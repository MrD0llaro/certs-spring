package it.traning.eng.spring;

import it.traning.eng.spring.aop.AOPBean;
import it.traning.eng.spring.beans.MyBeanInterface;
import it.traning.eng.spring.beans.OtherBeanInterface;
import it.traning.eng.spring.db.Person;
import it.traning.eng.spring.db.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class App {

    @Autowired
    public MyBeanInterface myBean;

    @Autowired
    @Qualifier("myBeanTwo")
    public OtherBeanInterface myBeanTwo;

    @Autowired
    JdbcOperations jdbc;


    @Autowired
    public  AOPBean aopBean;
    public static void main(String[] args) {
        // appication context
        //System.out.println("<<<<< " + App.class.getName() + "  STARTING >>>>>");
        ApplicationContext ctx = new AnnotationConfigApplicationContext("it.traning.eng.spring");
        final App bean = ctx.getBean(App.class);
        bean.start(args);
        ((AnnotationConfigApplicationContext) ctx).close();

      //  System.out.println("<<<<< ALL MY BEAN [profiles - " + getStringFromArray(ctx.getEnvironment().getActiveProfiles()) + "] >>>>>");
      //  printArrays(((AnnotationConfigApplicationContext)ctx).getBeanFactory().getBeanDefinitionNames());
      //  System.out.println("<<<<< " + App.class.getName() + "  FINISH >>>>>");

    }


    public void start(String[] args) {
      /*  System.out.println("<<<<< "+App.class.getName()+"  START >>>>>");
        myBean.execute();
        aopBean.sum(10,1);
        aopBean.sub(5,1);

        System.out.println( aopBean.testCorrect("ciccio"));
        System.out.println(aopBean.testCorrect("ciccio"));
        System.out.println(aopBean.testCorrect("ciccio"));
   */

        jdbc.execute("INSERT INTO person(id,firstName,lastName,email) VALUES (1,'Mario','Cartia','mario.cartia@gmail.com')");
        jdbc.execute("INSERT INTO person(id,firstName,lastName,email) VALUES (2,'Luca','Musa','luca.musa@gmail.com')");
        final SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM person");
        while(sqlRowSet.next()){
            final String email = sqlRowSet.getString("email");
            System.out.println(email);

        }

        List<Person> persons = jdbc.query("SELECT * FROM person", new PersonMapper());

        System.out.println(persons.size());
        for(Person p : persons){
            System.out.println(p.toString());

        }

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


}
