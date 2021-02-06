package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
public class CorrectionNew {

    private Integer id;

    private LocalDate dateCorrection;

    private Double correction;


}
