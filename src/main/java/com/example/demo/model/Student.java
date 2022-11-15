package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "student_id")
    private int student_id;

    @Column (name = "student_name")
    private String student_name;

    @Column (name = "birthday")
    private Date birthday;

    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "class_id")
    private Class classs;



    @JsonIgnore
    @OneToMany(mappedBy = "student",
            cascade = CascadeType.ALL)
    private List<Result> results = new ArrayList<>();
}
