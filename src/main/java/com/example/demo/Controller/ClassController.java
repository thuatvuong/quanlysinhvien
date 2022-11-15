package com.example.demo.Controller;

import com.example.demo.Service.ClassService;
import com.example.demo.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classs")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping ("")
    public List<Class> getListClass () {
        return classService.getListClass();
    }

    @GetMapping("/{id}")
    public Class getClassById (@PathVariable("id") int id) {
        return classService.getClassById(id);
    }

    @PostMapping ("/create")
    public Class createClass (@RequestBody Class classs) {
        return classService.creteClass(classs);
    }

    @PutMapping ("/update/{id}")
    public Class updateClass (@RequestBody Class classs, @PathVariable int id) {
        return classService.updateClass(id, classs);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteClass (@PathVariable ("id") int id) {
        return classService.deleteClassById(id);
    }

}
