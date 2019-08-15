package com.venkatyarlagadda.jwt.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venkatyarlagadda.jwt.api.controller.StudentController;
import com.venkatyarlagadda.jwt.api.dto.StudentDTO;
import com.venkatyarlagadda.jwt.api.entity.Student;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Venkat Yarlagadda
 * @version V1
 *
 */
@RestController
@RequestMapping("/JWT/v1")
public class JwtApi {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	StudentController studentController;
	
	@ApiOperation(
			value = "Get all Students",
			notes = "Get all Students")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok", responseContainer = "List", response = Student.class) })
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents() {
		return studentController.getStudent();
	}

	@ApiOperation(
			value = "Add a Student",
			notes = "Add a Student")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok", response = Student.class) })
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@Valid @RequestBody final StudentDTO studentDto) {
		log("Adding student {}", studentDto.getName());
		return studentController.addStudent(studentDto);
	}
	
	@ApiOperation(
			value = "Delete a Student",
			notes = "Delete a Student")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Ok") })
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("studentId") final Long studentId) {
		log("Deleting Student with studentId: {}" , studentId);
		return studentController.deleteStudent(studentId);
	}
	
	private void log(final String logMessage, Object... arguments) {
		LOGGER.debug(logMessage, arguments);
	}
}
