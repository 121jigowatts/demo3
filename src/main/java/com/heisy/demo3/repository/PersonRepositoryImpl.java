package com.heisy.demo3.repository;

import java.util.ArrayList;
import java.util.List;

import com.heisy.demo3.domain.model.Person;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public List<Person> selectAll() {
        return this.initData();
    }

    private List<Person> initData() {
        List<Person> people = new ArrayList<>();
        Person alice = Person.builder().firstName("Alice").lastName("Wonder").build();
        people.add(alice);

        Person bob = Person.builder().firstName("Bob").lastName("Gale").build();
        people.add(bob);

        Person chris = Person.builder().firstName("Chris").lastName("Carter").build();
        people.add(chris);

        return people;
    }
}