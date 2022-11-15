package com.example.demo.Controller;


import com.example.demo.Service.StudentService;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> getListClass () {
        return studentService.getListStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById (@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/create")
    public Student createStudent (@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @PutMapping ("/update/{id}")
    public Student updateStudent (@RequestBody Student student, @PathVariable int id) {
        return  studentService.updaeStudent(id, student);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteStudent (@PathVariable int id) {
        return studentService.delelteStudentById(id);
    }
}
