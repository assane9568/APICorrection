package com.example.demo.controller;


import com.example.demo.dto.MembersDto;
import com.example.demo.mapper.MapperMember;
import com.example.demo.model.Members;
import com.example.demo.service.MembersService;
import com.example.demo.service.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/members")
public class MembersController {
    @Autowired
    MembersService membersService = new MembersServiceImpl();

    @PostMapping(value="/addMembers")
    public ResponseEntity<String> createMembers(@RequestBody Members members) {
try {
    this.membersService.createMembers(members);
    return new  ResponseEntity<>("Member created successfully!!",HttpStatus.OK);
}
catch (Exception e)
{
    return new  ResponseEntity<>("Error occurred during the process!!",HttpStatus.INTERNAL_SERVER_ERROR);
}

    }




    @GetMapping(value="/ListMembers")
    public ResponseEntity<List<MembersDto>> findAllMembers(){

        List<Members> members = this.membersService.findAllMembers();
        List<MembersDto> membersDtos = new ArrayList<>();
        for (Members member : members)
        {
            membersDtos.add(MapperMember.membersToDtomembers(member));
        }
        return  new ResponseEntity<>(membersDtos, HttpStatus.ACCEPTED);

    }

    @GetMapping(value="/ListMembers/{id}")
    public ResponseEntity<Optional<Members>> findMembersById(@PathVariable Integer id){
        return  new ResponseEntity<>(membersService.findMembersById(id), HttpStatus.ACCEPTED);

    }

    @DeleteMapping(value = "/deleteMembers/{id}")
    public ResponseEntity<String> deleteMembers(@PathVariable Integer id){

        if(membersService.findMembersById(id).isPresent()){
            this.membersService.deleteMembers(id);
            return new  ResponseEntity<>("Member deleted successfully!!",HttpStatus.OK);
        }
        else {
            return new  ResponseEntity<>("Member not found",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="/updateMembers/{id}")
    public ResponseEntity<String>updateMembers(@RequestBody Members members ,@PathVariable Integer id) {
        try {
            if(membersService.findMembersById(id).isPresent()){
                membersService.findMembersById(id).get();
                members.setLastname(members.getLastname());
                members.setFirstname(members.getFirstname());
                members.setUsername(members.getUsername());
                members.setPassword(members.getPassword());
                this.membersService.updateMembers(members);
                return new  ResponseEntity<>("Member updated successfully!!",HttpStatus.OK);
            }
            else {
                return new  ResponseEntity<>("Member not found!!",HttpStatus.NOT_FOUND);
            }

        }
        catch (Exception e)
        {
            return new  ResponseEntity<>("Error occurred during the process!!",HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


}
