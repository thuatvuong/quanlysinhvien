package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Table (name ="classs")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "class_id")
    private int class_id;

    @Column (name = "class_code")
    private String class_code;

    @JsonIgnore
    @OneToMany (fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "classs")
    private List<Student> students;

    public void add(Student a) {
        if (students == null) {
            students = new ArrayList<Student>();
        }
        students.add(a);
        a.setClasss(this);
    }

}
