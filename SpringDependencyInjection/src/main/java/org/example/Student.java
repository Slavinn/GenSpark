package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// Java Configuration
@Configuration

public class Student {

    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;

    @Autowired
    public Student() {
        this.id = 23;
        this.name = "John Smith";
    }

    @Bean
    public Address createAddress() {
        return new Address("Los Angeles","CA","Los Angeles County","90004");
    }

    @Bean
    public Phone createPhone() {
        return new Phone();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Phone> getPh() {
        return ph;
    }

    public Address getAdd() {
        return add;
    }


}
