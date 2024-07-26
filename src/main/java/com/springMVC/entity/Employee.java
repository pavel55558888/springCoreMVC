package com.springMVC.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @NotBlank
    @Column(name = "name")
    private String name;
    @NotBlank
    @Column(name = "surname")
    private String surname;
    @NotBlank
    @Column(name = "department")
    private String department;
    @NotNull
    @Column(name = "salary")
    private int salary;
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    @Column(name = "number")
    private String number;
    @Pattern(regexp = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}")
    @Column(name = "email")
    private String email;

    public Employee(String name, String surname, String department, int salary, String number, String email) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.number = number;
        this.email = email;
    }
}
