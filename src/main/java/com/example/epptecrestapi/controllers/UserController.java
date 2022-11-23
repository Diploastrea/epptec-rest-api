package com.example.epptecrestapi.controllers;

import com.example.epptecrestapi.models.DTOs.ErrorDTO;
import com.example.epptecrestapi.models.DTOs.MessageDTO;
import com.example.epptecrestapi.models.DTOs.PersonDTO;
import com.example.epptecrestapi.models.Person;
import com.example.epptecrestapi.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {
    private final PersonService personService;

    @PostMapping("/person")
    public ResponseEntity<Object> addUser(@Valid @RequestBody Person person) {
        if (personService.idExists(person.getIdNumber())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("ID number must be unique!"));
        }
        personService.addPerson(person);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO("Added new person successfully."));
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<Object> removeUser(@PathVariable("id") String id) {
        if (!personService.idExists(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("No person found with provided ID!"));
        }
        personService.removePerson(id);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO("Removed person successfully."));
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Object> findUser(@PathVariable("id") String id) {
        if (!personService.idExists(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("No person found with provided ID!"));
        }
        PersonDTO person = personService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
