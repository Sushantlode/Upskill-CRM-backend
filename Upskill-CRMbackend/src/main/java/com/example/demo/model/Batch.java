package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "batches")
@Getter
@Setter 
@NoArgsConstructor
@AllArgsConstructor
public class Batch {

    @Id
    @Column(name = "batch_name")
    private String batchName;

    private String batchSubject;

    private LocalDate startDate;
    private LocalDate endDate;


    private String  mode;

    // One batch can have many students
    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Student> students;


}

