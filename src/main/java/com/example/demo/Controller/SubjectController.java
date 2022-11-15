package com.example.demo.Controller;

import com.example.demo.Service.StudentService;
import com.example.demo.Service.SubjectService;
import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("")
    public List<Subject> getListClass () {
        return subjectService.getListSubject();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById (@PathVariable int id) {
        return subjectService.getSubjectById(id);
    }

    @PostMapping("/create")
    public Subject createSubject (@RequestBody Subject subject) {

        return subjectService.createSubject(subject);
    }

    @PutMapping ("/update/{id}")
    public Subject updatesubjectService (@RequestBody Subject subject, @PathVariable int id) {
        return  subjectService.updateSubject(id, subject);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteSubject (@PathVariable int id) {
        return subjectService.delelteSubjectById(id);
    }
}
