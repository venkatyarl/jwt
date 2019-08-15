package com.venkatyarlagadda.jwt.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.venkatyarlagadda.jwt.api.dto.StudentDTO;
import com.venkatyarlagadda.jwt.api.entity.Student;
import com.venkatyarlagadda.jwt.api.repository.StudentRepository;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;

	public ResponseEntity<List<Student>> getStudent() {
		return ResponseEntity.ok().body(studentRepository.findAll());
	}

	public ResponseEntity<Student> addStudent(final StudentDTO studentDto) {
		final Student student = studentRepository.save(Student.build(studentDto));
		return ResponseEntity.ok().body(student);
	}

	public ResponseEntity<Boolean> deleteStudent(final Long studentId) {
		studentRepository.deleteById(studentId);
		return ResponseEntity.ok().body(Boolean.TRUE);
	}
}