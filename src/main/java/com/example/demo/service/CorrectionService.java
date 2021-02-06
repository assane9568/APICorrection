package com.example.demo.service;

import com.example.demo.model.Correction;

import java.util.List;
import java.util.Optional;

public interface CorrectionService {

    Correction createCorrection(Correction correction);

    Correction updateCorrection(Correction correction);

    List<Correction> findAllCorrection();

    Optional<Correction> findCorrectionById(Integer id);

    void deleteCorrection(Integer id);
}
