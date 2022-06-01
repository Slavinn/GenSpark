package com.slavinn.springbootrestapione.rest;


import com.slavinn.springbootrestapione.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentRestController {

    List<Student> students;

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student(1,"John", "Doe", "john.doe@email.com"));
        students.add(new Student(2,"James", "Smith", "james.smith@email.com"));
        students.add(new Student(3,"Sammy", "lee", "sammy.lee@email.com"));
        students.add(new Student(4,"Erin", "Cart", "erin.cart@email.com"));
        students.add(new Student(5,"Billy", "Wall", "billy.wall@email.com"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) throws Exception {
        Student theStudent = null;

        for (Student student : students) {
            if (student.getId() == studentId) {
                theStudent = student;
                break;
            }
        }
        if (theStudent == null) {
            throw new Exception("Student ID not found - " + studentId);
        }

        return theStudent;
    }

    @RequestMapping("/students")
    public String addStudent(@RequestBody Student theStudent){
        for (Student student : students) {
            if(theStudent.getId() == student.getId()) {
                return "Student already exists";
            }
        }

        students.add(theStudent);
        return "Added student - " + theStudent;
    }

    @PutMapping("/students")
    public String updateStudent(@RequestBody Student theStudent) throws Exception {

        for (Student student : students) {
            if (student.getId() == theStudent.getId()) {
                student = theStudent;
                return "Student updated -" + student;
            }
        }
        return "Student not found - " + theStudent;

    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {

        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                return "Deleted Student - " + studentId;

            }
        }
        return "Student ID not found - " + studentId;
    }
}
