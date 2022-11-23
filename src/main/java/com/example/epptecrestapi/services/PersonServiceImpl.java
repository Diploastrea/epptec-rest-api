package com.example.epptecrestapi.services;

import com.example.epptecrestapi.models.DTOs.PersonDTO;
import com.example.epptecrestapi.models.Person;
import com.example.epptecrestapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;

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
    public PersonDTO findById(String id) {
        id = parseIdNumber(id);
        Person person = personRepository.findByIdNumber(id).orElseThrow(IllegalArgumentException::new);
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        int age = calculateAge(id);
        return new PersonDTO(firstName, lastName, age, id);
    }

    @Override
    public String parseIdNumber(String id) {
        return id.matches("\\d{10}") ?
                id.substring(0, 6) + "/" + id.substring(6)
                : id;
    }

    @Override
    public int calculateAge(String id) {
        int year = Integer.parseInt(id.substring(0, 2));
        int currentYear = Year.now().getValue() - 2000;
        year = year > currentYear ? 1900 + year : 2000 + year;
        String dateInString = year + id.substring(2, 6);
        LocalDate birthDate = LocalDate.parse(dateInString, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}
