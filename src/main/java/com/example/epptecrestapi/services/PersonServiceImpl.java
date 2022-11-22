package com.example.epptecrestapi.services;

import com.example.epptecrestapi.models.Person;
import com.example.epptecrestapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public boolean idExists(String id) {
        id = parseIdNumber(id);
        return personRepository.findByIdNumber(id).isPresent();
    }

    @Override
    public void addPerson(Person person) {
        String id = parseIdNumber(person.getIdNumber());
        person.setIdNumber(id);
        personRepository.save(person);
    }

    @Override
    public void removePerson(String id) {
        id = parseIdNumber(id);
        personRepository.deleteById(id);
    }

    @Override
    public String parseIdNumber(String id) {
        return id.matches("\\d{10}") ?
                id.substring(0, 6) + "/" + id.substring(6)
                : id;
    }
}
