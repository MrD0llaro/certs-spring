package it.traning.eng.spring.db;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setEmail(rs.getString("email"));
        p.setLastName(rs.getString("lastName"));
        p.setFirstName(rs.getString("firstName"));

        return p;
    }
}
