package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "correction")
public class Correction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column(unique = true)
    private LocalDate dateCorrection;
    @Column
    private Double correction;
    @ManyToOne
    @JsonBackReference
    private Members members ;

    }
