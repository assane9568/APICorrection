package com.example.demo.service;

import com.example.demo.model.Correction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.CorrectionRepository;

import java.util.*;
@Service
public class CorrectionServiceImpl implements CorrectionService{
    @Autowired
    CorrectionRepository correctionRepository;
    @Override
    public Correction createCorrection(Correction correction) { return correctionRepository.save(correction); }
    @Override
    public Correction updateCorrection(Correction correction) {return correctionRepository.save(correction); }

    @Override
    public Optional<Correction> findCorrectionById(Integer id) { return correctionRepository.findById(id); }

    @Override
    public List<Correction> findAllCorrection() {
       return (List<Correction>) correctionRepository.findAll();
    }

    @Override
    public void deleteCorrection(Integer id) {
        correctionRepository.deleteById(id);
    }

}
