package com.example.demo.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Class;
import com.example.demo.repository.ClasssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClassServiceIpm implements ClassService {

    @Autowired
    private ClasssRepository classRepository;

    @Override
    public List<Class> getListClass() {
        return classRepository.findAll();
    }

    @Override
    public Class getClassById(int class_id) {
        Optional<Class> class1 = classRepository.findById(class_id);
        if (!class1.isPresent()) {
            throw new NotFoundException("Khong ton tai ma");
        } else {
            return class1.get();
        }}

    @Override
    public Class creteClass(Class class1) {
        if (class1 != null) {
            return classRepository.save(class1);
        }
        return null;
    }

    @Override
    public Class updateClass(int class_id, Class class1) {
        if (class1 != null) {
          Optional <Class> class2 = classRepository.findById(class_id);
            if (!class2.isPresent()) {
                throw new NotFoundException("Lop khong ton tai");
            }
            else {
                class2.get().setClass_code(class1.getClass_code());
                return classRepository.save(class2.get());
            }
        }
        return null;
    }

    @Override
    public boolean deleteClassById(int id) {
        boolean exists  = classRepository.existsById(id);
        if (!exists) {
            throw new NotFoundException("Lop khong ton tai");
        }
        else {
            classRepository.deleteById(id);
        }
        return true;
    }

}
