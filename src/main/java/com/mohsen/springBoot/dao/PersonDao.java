package com.mohsen.springBoot.dao;

import com.mohsen.springBoot.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insetPerson(UUID id, Person person);

    default int insetPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insetPerson(id, person);
    }


    List<Person> selectAllPeople();

    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person newPerson);
    Optional<Person> selectPersonById(UUID id);
}
