package com.example.epptecrestapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "people")
@Data
public class Person {
    @NotBlank(message = "First name cannot be empty!")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty!")
    private String lastName;
    @Id
    @Pattern(regexp = "(\\d{6}/\\d{4}|\\d{10})", message = "ID number must be in 'YYMMDD/XXXX' or 'YYMMDDXXXX' format!")
    private String idNumber;
}
