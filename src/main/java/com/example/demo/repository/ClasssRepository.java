package com.example.demo.repository;

import com.example.demo.model.Class;
import com.example.demo.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasssRepository extends JpaRepository<Class,  Integer> {
}
