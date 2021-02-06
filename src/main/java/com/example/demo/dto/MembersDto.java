package com.example.demo.dto;

import com.example.demo.model.CorrectionNew;
import lombok.Data;

import java.util.List;

@Data

public class MembersDto {
    private Integer id;
    private String lastname;
    private String firstname;
    private String username;
    private String password;
    private List<CorrectionNew> correctionNews;


}
