package com.venkatyarlagadda.jwt.api.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Venkat Yarlagadda
 * @version V1
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
	private String name;
	private String sex;
	private String dateOfBirth;
	private int age;
	private boolean legal;
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public LocalDateTime getDateOfBirthInLDT() {
		//TODO Convert Date of birth to local date time
		return LocalDateTime.now();
	}
}