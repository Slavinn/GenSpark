package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//         Dependancy Injection XML

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Address theAddress = context.getBean("address", Address.class);
        System.out.println("XML CONFIG:");
        System.out.println(theAddress);


        // Annotation with default bean id
        Phone thePhone = context.getBean("phone", Phone.class);
        System.out.println(thePhone);
        context.close();

//         Java Config

        AnnotationConfigApplicationContext javaConfigContext = new AnnotationConfigApplicationContext(Student.class);


        Student theStudent = javaConfigContext.getBean("student", Student.class);
        Address javaConfigAddress = javaConfigContext.getBean("createAddress", Address.class);
        Phone javaConfigPhone = javaConfigContext.getBean("createPhone", Phone.class);
//
//
        System.out.println("\n\nJAVA CONFIG: ");
        System.out.println(javaConfigAddress);
        System.out.println(javaConfigPhone);
        System.out.println(theStudent.getName());
        System.out.println(theStudent.getId());
        javaConfigContext.close();





    }
}