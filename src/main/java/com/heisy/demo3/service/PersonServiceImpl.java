package com.heisy.demo3.service;

import java.util.List;

import com.heisy.demo3.domain.model.Person;
import com.heisy.demo3.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> selectAll() {
        return personRepository.selectAll();
    }

}