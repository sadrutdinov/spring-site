package com.kickboxing18.site.controllers;


import com.google.gson.Gson;
import com.kickboxing18.site.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(value = "/rest/people")
public class Rest {

    private final PersonDao personDao;

    @Autowired
    public Rest(PersonDao personDao) {
        this.personDao = personDao;
    }


    @GetMapping("/all")
    public String getAllUsers() {
        return new Gson().toJson(personDao.index());
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable(name = "id") int id) {
        return new Gson().toJson(personDao.show(id));
    }




}
