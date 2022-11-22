package com.example.epptecrestapi.repositories;

import com.example.epptecrestapi.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
