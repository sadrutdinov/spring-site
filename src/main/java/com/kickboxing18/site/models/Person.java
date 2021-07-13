package com.kickboxing18.site.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int id;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "Длина имени возможна от 2 до 30 символов")
    private String name;

    @Min(value = 0, message = "Возраст должен быть больше 0")
    private int age;

    @NotEmpty(message = "Email не может быть пустым")
    @Email(message = "Email должен быть валидным")
    private String email;

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person() {
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
