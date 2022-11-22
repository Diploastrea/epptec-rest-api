package com.example.epptecrestapi.repositories;

import com.example.epptecrestapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findByIdNumber(String id);
}
