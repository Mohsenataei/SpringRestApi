package com.mohsen.springBoot.dao;

import com.mohsen.springBoot.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Postgres")
public class PersonDataAccessService implements PersonDao {
    private final JdbcTemplate jdbcTemplate;

    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insetPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name from person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id, name);
        });
//        return List.of(new Person(UUID.randomUUID(), "SELECT FROM POSGRES DB"));
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person newPerson) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(personId, name);
        });
        return Optional.ofNullable(person);
    }
}
