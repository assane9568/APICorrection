package com.example.demo.controller;

import com.example.demo.dto.CorrectionsDto;
import com.example.demo.dto.CorrectionsDto1;
import com.example.demo.dto.MembersDto;
import com.example.demo.mapper.MapperMember;
import com.example.demo.mapper.MapperMemberNew;
import com.example.demo.model.Correction;
import com.example.demo.model.Members;
import com.example.demo.model.MembersNew;
import com.example.demo.service.MembersService;
import com.example.demo.service.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.CorrectionService;
import com.example.demo.service.CorrectionServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/correction")
public class CorrectionController {

    @Autowired
    CorrectionService correctionService = new CorrectionServiceImpl();

    @Autowired
    MembersService membersService= new MembersServiceImpl();

    @PostMapping(value="/addCorrection")
    public ResponseEntity<String> createCorrection(@RequestBody CorrectionsDto correctionsDto) {
try {
    if(membersService.findMembersById(correctionsDto.getMemberId()).isPresent()){
        List<Members> members = this.membersService.findAllMembers();
        Correction correction = new Correction();
        for (Members member : members)
        {

            if(member.getId().equals(correctionsDto.getMemberId()))
            {
                correction.setId(correctionsDto.getId());
                correction.setDateCorrection(correctionsDto.getDateCorrection());
                correction.setCorrection(correctionsDto.getCorrection());
                correction.setMembers(member);
                break;
            }
        }

        this.correctionService.createCorrection(correction);
        return new  ResponseEntity<>("Correction added successfully!!",HttpStatus.BAD_REQUEST);
    }
    else {

        return new  ResponseEntity<>(" this Member doesn't exist!!!",HttpStatus.OK);

    }

}
catch (Exception e)
{
    return new  ResponseEntity<>(" Error occurred during the process!!!",HttpStatus.INTERNAL_SERVER_ERROR);
}

    }

    @GetMapping(value="/ListCorrection")
    public ResponseEntity<List<CorrectionsDto1>> findAllCorrection() {
        MapperMemberNew mapperMemberNew = new MapperMemberNew();
        List<Correction> corrections = this.correctionService.findAllCorrection();
        List<CorrectionsDto1> correctionsDto1s = new ArrayList<>();
        for (Correction correction : corrections) {
            CorrectionsDto1 correctionsDto1 = new CorrectionsDto1();
            MembersNew membersNew = new MembersNew();
            correctionsDto1.setId(correction.getId());
            correctionsDto1.setCorrection(correction.getCorrection());
            correctionsDto1.setDateCorrection(correction.getDateCorrection());
            membersNew = mapperMemberNew.membersToMembersNew(correction.getMembers());
            correctionsDto1.setMembersNews(membersNew);
            correctionsDto1s.add(correctionsDto1);

        }
        return new ResponseEntity<>(correctionsDto1s, HttpStatus.ACCEPTED);

    }

    @GetMapping(value="/ListCorrection/{id}")
    public ResponseEntity< Optional <Correction> >findCorrectionById(@PathVariable Integer id){
        return  new ResponseEntity<>(correctionService.findCorrectionById(id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/deleteCorrection/{id}")
    public ResponseEntity<String>  deleteCorrection(@PathVariable Integer id){
        if(correctionService.findCorrectionById(id).isPresent()) {
            this.correctionService.deleteCorrection(id);
            return new  ResponseEntity<>("Correction deleted successfully!!",HttpStatus.OK);
        }
        else
        {
            return new  ResponseEntity<>("Correction not found!!",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="/updateCorrection/{id}")
    public ResponseEntity<String> updateCorrection(@RequestBody Correction correction ,@PathVariable Integer id) {
        try {
            if(correctionService.findCorrectionById(id).isPresent()){
                correctionService.findCorrectionById(id);
                correction.setCorrection(correction.getCorrection());
                this.correctionService.updateCorrection(correction);



                return new  ResponseEntity<>("Correction updated successfully!!",HttpStatus.OK);
            }
            else {
                return new  ResponseEntity<>("Correction not found!!",HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            return new  ResponseEntity<>("Error occurred during the process!!",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
