package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
public class MembersNew {

    private Integer id;

    private String lastname;

    private String firstname;

    private String username;

    private String password;


}
