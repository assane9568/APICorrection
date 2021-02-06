package com.example.demo.repository;

import com.example.demo.model.Members;
import org.springframework.data.repository.CrudRepository;

public interface MembersRepository extends CrudRepository<Members, Integer> {
}
