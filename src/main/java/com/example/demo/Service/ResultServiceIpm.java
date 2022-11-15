package com.example.demo.Service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Result;
import com.example.demo.model.Subject;
import com.example.demo.repository.ResultRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ResultServiceIpm implements ResultService{
    @Autowired
    private ResultRepository resultRepository;

    @Override
    public List<Result> getListResult() {
        return resultRepository.findAll();
    }

    @Override
    public Result getResultById(int id) {
        Optional<Result> result1 = resultRepository.findById(id);
        if (!result1.isPresent()) {
            throw new NotFoundException("Khong tim thay ma sinh vien");
        }
        else {
            return result1.get();
        }
    }

    @Override
    public Result createResult(Result result) {
        return  resultRepository.save(result);
    }

    @Override
    public Result updateResult (int id, Result result) {
        Optional<Result> result1 = resultRepository.findById(id);
        if (!result1.isPresent()) {
            throw  new NotFoundException("Khong tim thay sinh vien");
        }
        else {
            result1.get().setMark(result.getMark());
            return resultRepository.save(result1.get());
        }
    }

    @Override
    public boolean delelteResultById(int id) {
        Optional<Result> result1 = resultRepository.findById(id);
        if (!result1.isPresent()) {
            throw  new NotFoundException("Khong tim thay sinh vien");
        }
        else  {
            resultRepository.deleteById(id);
            return true;
        }
    }
}
