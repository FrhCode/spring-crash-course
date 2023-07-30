package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public List<Student> getStudents() {

		return List.of(new Student("Rizman", "rizman@gmail.com", LocalDate.now()));
	}

	@PostMapping
	public String addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
}
