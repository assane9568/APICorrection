package com.example.demo.dto;

import com.example.demo.model.CorrectionNew;
import com.example.demo.model.MembersNew;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CorrectionsDto1 {
    private Integer id;
    private LocalDate dateCorrection;
    private Double correction;
    private MembersNew MembersNews;
}
