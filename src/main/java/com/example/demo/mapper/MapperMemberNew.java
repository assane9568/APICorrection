package com.example.demo.mapper;

import com.example.demo.model.Members;
import com.example.demo.model.MembersNew;

public class MapperMemberNew {

    public static MembersNew membersToMembersNew(Members members) {

        MembersNew membersNew = new MembersNew();
        membersNew.setId(members.getId());
        membersNew.setLastname(members.getLastname());
        membersNew.setFirstname(members.getFirstname());
        membersNew.setUsername(members.getUsername());
        membersNew.setPassword(members.getPassword());

        return membersNew;


    }
}
