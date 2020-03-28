package com.mohsen.springBoot.service;

import com.mohsen.springBoot.dao.PersonDao;
import com.mohsen.springBoot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("Postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insetPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }
}
