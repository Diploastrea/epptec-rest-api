package com.example.epptecrestapi.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "people")
@Data
public class Person {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Id
    private String idNumber;
}
