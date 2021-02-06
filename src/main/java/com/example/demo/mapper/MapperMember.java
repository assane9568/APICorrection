package com.example.demo.mapper;

import com.example.demo.dto.MembersDto;
import com.example.demo.model.Correction;
import com.example.demo.model.CorrectionNew;
import com.example.demo.model.Members;

import java.util.ArrayList;
import java.util.List;

public class MapperMember {


    public static MembersDto membersToDtomembers(Members members) {

        MembersDto membersDto = new MembersDto();
        membersDto.setId(members.getId());
        membersDto.setLastname(members.getLastname());
        membersDto.setFirstname(members.getFirstname());
        membersDto.setUsername(members.getUsername());
        membersDto.setPassword(members.getPassword());

        List<CorrectionNew> result = new ArrayList<>();
        CorrectionNew correctionNew = new CorrectionNew();
        List<Correction> cor = members.getCorrections();
        for (Correction correction : cor) {
            correctionNew.setDateCorrection(correction.getDateCorrection());
            correctionNew.setId(correction.getId());
            correctionNew.setCorrection(correction.getCorrection());
            result.add(correctionNew);
        }
        membersDto.setCorrectionNews(result);
        return membersDto;


    }
}