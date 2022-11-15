package com.example.demo.Service;


import com.example.demo.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {
    public List<Subject> getListSubject ();

    public Subject getSubjectById (int id);

    public Subject createSubject (Subject subject);

    public Subject updateSubject(int id, Subject subject);

    public boolean delelteSubjectById (int id);
}
