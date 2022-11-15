package com.example.demo.Controller;

import com.example.demo.Service.ResultService;
import com.example.demo.Service.StudentService;
import com.example.demo.model.Result;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @GetMapping("")
    public List<Result> getListResult() {
        return resultService.getListResult();
    }

    @GetMapping("/{id}")
    public Result getResultById (@PathVariable int id) {
        return resultService.getResultById(id);
    }

    @PostMapping("/create")
    public Result createStudent (@RequestBody Result result) {

        return resultService.createResult(result);
    }

    @PutMapping ("/update/{id}")
    public Result updateResult (@RequestBody Result result, @PathVariable int id) {
        return  resultService.updateResult(id, result);
    }

    @DeleteMapping ("/delete/{id}")
    public boolean deleteResult (@PathVariable int id) {
        return resultService.delelteResultById(id);
    }
}
