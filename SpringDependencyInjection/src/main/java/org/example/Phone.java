package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component // default bean id will be class with first letter lowercase of class phone
@Component
public class Phone {

    private String mob;
    @Autowired
    public Phone() {
        this.mob = "345-234-1743";
    }

    public String getMob() {
        return mob;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "mob='" + mob + '\'' +
                '}';
    }
}
