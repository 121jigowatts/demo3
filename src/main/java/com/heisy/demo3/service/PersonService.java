package com.heisy.demo3.service;

import java.util.List;

import com.heisy.demo3.domain.model.Person;

public interface PersonService {
    List<Person> selectAll();
}