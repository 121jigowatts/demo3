package com.heisy.demo3.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Person {

    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }

}