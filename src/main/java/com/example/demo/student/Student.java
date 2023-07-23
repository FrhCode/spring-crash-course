package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;



    @Transient
    private Integer age;

    public Student() {
    }

    public Student(String name, String email, LocalDate dateOfBirdth) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirdth;
    }

    public Student(UUID id, String name, String email, LocalDate dateOfBirdth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirdth;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirdth) {
        this.dateOfBirth = dateOfBirdth;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirdth=" + dateOfBirth +
                '}';
    }
}
