package com.example.demo.Service;

import com.example.demo.model.Class;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClassService {
    public List<Class> getListClass();

    public Class getClassById (int id);

    public Class creteClass (Class classs);

    public Class updateClass (int class_id, Class class1 );

    public boolean deleteClassById (int id);

}
