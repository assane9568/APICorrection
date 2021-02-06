package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class CorrectionsDto {
    private Integer id;
    private LocalDate dateCorrection;
    private Double correction;
    private Integer memberId;

}
