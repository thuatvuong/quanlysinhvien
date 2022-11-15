package com.example.demo.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentServiceIpm implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getListStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        Optional <Student> student1 = studentRepository.findById(id);
        if (!student1.isPresent()) {
            throw new NotFoundException("Khong tim thay ma sinh vien");
        }
        else {
            return student1.get();
        }
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updaeStudent(int id, Student student) {
        Optional<Student> student1 = studentRepository.findById(id);
        if (!student1.isPresent()) {
            throw  new NotFoundException("Khong tim thay sinh vien");
        }
        else {
            student1.get().setStudent_name(student.getStudent_name());
            student1.get().setBirthday(student.getBirthday());
            return studentRepository.save(student1.get());
        }
    }

    public boolean delelteStudentById (int id) {
        Optional<Student> student1 = studentRepository.findById(id);
        if (!student1.isPresent()) {
            throw  new NotFoundException("Khong tim thay sinh vien");
        }
        else  {
            studentRepository.deleteById(id);
            return true;
        }
    }


}
