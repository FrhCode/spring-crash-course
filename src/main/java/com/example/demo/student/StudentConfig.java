package com.example.demo.student;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{
            List<Student> students = new ArrayList<>();
            Faker faker = new Faker();
            LocalDate from = LocalDate.of(1999, Month.JANUARY, 1);
            LocalDate to = LocalDate.of(2020, Month.DECEMBER, 1);

            for (int i = 0; i < 100; i++) {
                String name = faker.name().fullName();
                String email = faker.internet().emailAddress();
                LocalDate date = getRandomDateBetween(from, to);
                Student student = new Student(name,email,date);

                students.add(student);
            }

            studentRepository.saveAll(students);
        };
    }

    public static LocalDate getRandomDateBetween(LocalDate from, LocalDate to) {
        long daysBetween = ChronoUnit.DAYS.between(from, to);
        long randomDays = ThreadLocalRandom.current().nextLong(daysBetween + 1);
        return from.plusDays(randomDays);
    }
}
