package com.example.demo.model;

import com.example.demo.repository.CorrectionRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "members")
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private String username;
    @Column
    private String password;
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "members")
    @JsonManagedReference
    private List<Correction> Corrections;


}
