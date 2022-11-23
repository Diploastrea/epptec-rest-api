package com.example.epptecrestapi.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDTO {
    private String firstName;
    private String lastName;
    private Integer age;
    private String idNumber;
}
