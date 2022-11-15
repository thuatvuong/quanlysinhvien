package com.example.demo.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Subject;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SubjectIpm implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> getListSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectById(int id) {
        Optional<Subject> subject1 = subjectRepository.findById(id);
        if (!subject1.isPresent()) {
            throw new NotFoundException("Khong tim thay ma sinh vien");
        }
        else {
            return subject1.get();
        }
    }

    @Override
    public Subject createSubject(Subject subject) {
        return  subjectRepository.save(subject);
    }

    @Override
    public Subject updateSubject(int id, Subject subject) {
        Optional<Subject> subject1 = subjectRepository.findById(id);
        if (!subject1.isPresent()) {
            throw  new NotFoundException("Khong tim thay sinh vien");
        }
        else {
            subject1.get().setSubject_name(subject.getSubject_name());
            subject1.get().setSesstioncount(subject.getSesstioncount());
            return subjectRepository.save(subject1.get());
        }
    }

    @Override
    public boolean delelteSubjectById(int id) {
        Optional<Subject> subject1 = subjectRepository.findById(id);
        if (!subject1.isPresent()) {
            throw  new NotFoundException("Khong tim thay sinh vien");
        }
        else  {
            subjectRepository.deleteById(id);
            return true;
        }
    }
}
