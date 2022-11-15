package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name= "subject_id")
    private int subject_id;

    @Column (name= "subject_name")
    private String subject_name;

    @Column (name = "sesstioncount")
    private int sesstioncount;

    @JsonIgnore
    @OneToMany(mappedBy = "subject",
            orphanRemoval = true)
    private List<Result> results = new ArrayList<>();
}
