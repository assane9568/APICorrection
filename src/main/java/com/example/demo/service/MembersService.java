package com.example.demo.service;

import com.example.demo.model.Correction;
import com.example.demo.model.Members;

import java.util.List;
import java.util.Optional;

public interface MembersService {

    Members createMembers(Members members);

    Members updateMembers(Members members);

    List<Members> findAllMembers();

    Optional<Members> findMembersById(Integer id);

    void deleteMembers(Integer id);
}
