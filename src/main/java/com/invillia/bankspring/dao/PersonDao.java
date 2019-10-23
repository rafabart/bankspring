package com.invillia.bankspring.dao;

import com.invillia.bankspring.domain.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDao extends GenericDao<Person, Long> {
    public PersonDao() {
        super(Person.class);
    }
}