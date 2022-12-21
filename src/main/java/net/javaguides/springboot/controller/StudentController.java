package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "kenneth", "yeong");

        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "kenneth", "yeong"));
        students.add(new Student(2, "kenneth2", "yeong2"));

        return students;
    }

    // spring boot rest api with path variable
    // {id} - URO template variab
    // http://localhost:8080/student/100
    @GetMapping("student/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId) {
        return new Student(studentId, "kenneth", "yeong");
    }

    // http://localhost:8080/students/100/john/wick
    @GetMapping("student/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int id, @PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return new Student(id, firstName, lastName);
    }

    //  http://localhost:8080/student/query?id=100
    /* @GetMapping("student/query")
    // public Student studentRequestVariable(@RequestParam int id) {
    //    return new Student(id, "kenneth", "yeong");
    }*/

    //  http://localhost:8080/student/query?id=100&firstName=John&lastName=Wick
    @GetMapping("student/query")
    public Student studentRequestVariables(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
}
