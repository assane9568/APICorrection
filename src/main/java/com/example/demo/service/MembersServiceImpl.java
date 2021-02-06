package com.example.demo.service;

import com.example.demo.model.Correction;
import com.example.demo.model.Members;
import com.example.demo.repository.CorrectionRepository;
import com.example.demo.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MembersServiceImpl implements MembersService {
    @Autowired
    MembersRepository membersRepository;

    @Override
    public Members createMembers(Members members) {return membersRepository.save(members); }

    @Override
    public Members updateMembers(Members members) {
        return membersRepository.save(members);
    }

    @Override
    public List<Members> findAllMembers() {
        return (List<Members>) membersRepository.findAll();
    }

    @Override
    public Optional<Members> findMembersById(Integer id) {
        return membersRepository.findById(id);
    }

    @Override
    public void deleteMembers(Integer id) {
        membersRepository.deleteById(id);
    }
}
