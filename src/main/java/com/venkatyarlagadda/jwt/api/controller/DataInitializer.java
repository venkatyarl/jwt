package com.venkatyarlagadda.jwt.api.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.venkatyarlagadda.jwt.api.entity.Student;
import com.venkatyarlagadda.jwt.api.repository.StudentRepository;

@Component
public class DataInitializer implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		Arrays.asList(
				Student.build("Vinny", "Male", LocalDateTime.now(), 30, true),
				Student.build("Su", "Female", LocalDateTime.now(), 30, true),
				Student.build("Child", "Female", LocalDateTime.now(), 2, false))
		.forEach(student -> this.studentRepository.save(student));		
	}
}