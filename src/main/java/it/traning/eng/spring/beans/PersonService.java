package it.traning.eng.spring.beans;

import it.traning.eng.spring.db.Person;
import it.traning.eng.spring.db.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
@Service
public class PersonService {

    @Autowired
    PersonRepository repo;
    @Autowired
    PersonService self;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void savePerson(List<Person>persons){
        for (Person p: persons){
            if(new Random().nextBoolean()&&new Random().nextBoolean()&&new Random().nextBoolean()&&new Random().nextBoolean()){
                throw new RuntimeException("random error");
            }
            System.out.println("Saving "+p+" ...");
            repo.save(p);
        }

    }

    @Transactional()
    public void test(List<Person> persons){
        self.savePerson(persons);
    }
}
