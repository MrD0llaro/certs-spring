package it.traning.eng.spring.db;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT * FROM PERSON WHERE EMAIL =:email")
    List<Person> testQ(@Param("email")String email);
}
