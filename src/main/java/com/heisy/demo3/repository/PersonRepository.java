package com.heisy.demo3.repository;

import java.util.List;

import com.heisy.demo3.domain.model.Person;

public interface PersonRepository {
    List<Person> selectAll();
}