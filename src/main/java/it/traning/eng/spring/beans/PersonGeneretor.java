package it.traning.eng.spring.beans;

import com.github.javafaker.Faker;
import it.traning.eng.spring.db.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonGeneretor {

   private Faker facker;

    public PersonGeneretor() {
        super();
        this.facker = new Faker();
    }

    public Person buildPerson(){
        Person p = new Person();
        final String name = this.facker.name().firstName();
        final String surname = this.facker.name().lastName();

        final String email  = name+"."+surname+"@"+ this.facker.company().url();
        p.setLastName(surname);
        p.setFirstName(name);
        p.setEmail(email);
        return p;
    }

}
