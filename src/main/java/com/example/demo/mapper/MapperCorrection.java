package com.example.demo.mapper;

import com.example.demo.dto.CorrectionsDto;
import com.example.demo.model.Correction;

public class MapperCorrection {
    public static CorrectionsDto correctionToDtoCorrection (Correction correction){
        CorrectionsDto correctionDto=new CorrectionsDto();
        correctionDto.setId(correction.getId());
        correctionDto.setDateCorrection(correction.getDateCorrection());
        correctionDto.setCorrection(correction.getCorrection());
        correctionDto.setMemberId(correction.getMembers().getId());

        return correctionDto;

    }
}
