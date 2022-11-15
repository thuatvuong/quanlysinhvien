package com.example.demo.Service;

import com.example.demo.model.Result;
import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ResultService {
    public List<Result> getListResult ();

    public Result getResultById (int id);

    public Result createResult (Result result);

    public Result updateResult (int id, Result result);

    public boolean delelteResultById (int id);
}
