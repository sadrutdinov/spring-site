package com.kickboxing18.site.dao;

import com.kickboxing18.site.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;


// TODO: 13.07.2021 перевести на хибернейт 

@Component
public class PersonDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        // роумапер нужен, чтобы из строк собирались объекты
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {

        return jdbcTemplate.query("SELECT * FROM PERSON WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)", person.getName(), person.getAge(),
                person.getEmail());

    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE PERSON set name=?, age=?, email=? WHERE id = ?", updatedPerson.getName(),
                updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM PERSON WHERE id = ?", id);
    }
}
