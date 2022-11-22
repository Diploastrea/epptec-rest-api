package com.example.epptecrestapi.services;

import com.example.epptecrestapi.models.Person;

public interface PersonService {
    boolean idExists(String id);
    void addPerson(Person person);
    String parseIdNumber(String id);
}
