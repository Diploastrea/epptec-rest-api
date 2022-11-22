package com.example.epptecrestapi.services;

import com.example.epptecrestapi.models.Person;

public interface PersonService {
    boolean idExists(String id);
    void addPerson(Person person);
    void removePerson(String id);
    String parseIdNumber(String id);
}
