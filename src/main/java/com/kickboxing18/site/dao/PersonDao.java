package com.kickboxing18.site.dao;

import com.kickboxing18.site.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "aydar"));
        people.add(new Person(++PEOPLE_COUNT, "alex"));
        people.add(new Person(++PEOPLE_COUNT, "drew"));
        people.add(new Person(++PEOPLE_COUNT, "bob"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

}
