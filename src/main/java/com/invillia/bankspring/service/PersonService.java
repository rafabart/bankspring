package com.invillia.bankspring.service;

import com.invillia.bankspring.dao.PersonDao;
import com.invillia.bankspring.domain.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Person findOne(Long id) {
        return personDao.findById(id).get();
    }

    public void insert(Person person) {
        personDao.insert(person);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void delete(Long id) {
        personDao.deleteById(id);
    }
}