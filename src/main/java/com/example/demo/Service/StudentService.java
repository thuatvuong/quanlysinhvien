package com.example.demo.Service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public List<Student> getListStudent ();

    public Student getStudentById (int id);

    public Student createStudent (Student student);

    public Student updaeStudent (int id, Student student);

    public boolean delelteStudentById (int id);
}
