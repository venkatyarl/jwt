package com.venkatyarlagadda.jwt.api.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.venkatyarlagadda.jwt.AttributeConverters.LocalDateTimeToTimeStampAttributeConverter;
import com.venkatyarlagadda.jwt.api.dto.StudentDTO;

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
@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 9063436098230339864L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "sex")
	private String sex;
	
	@Column(name = "date_of_birth")
	@Convert(converter = LocalDateTimeToTimeStampAttributeConverter.class)
	private LocalDateTime dateOfBirth;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "legal")
	private boolean legal;

	public static Student build(final String name, final String sex, final LocalDateTime dateOfBirth, final int age, final boolean legal) {
		//@formatter:off
        return Student
                .builder()
                .name(name)
                .sex(sex)
                .dateOfBirth(dateOfBirth)
                .age(age)
                .legal(legal)
                .build();
        //@formatter:on
	}

	public static Student build(final StudentDTO studentDto) {
		//@formatter:off
        return Student
                .builder()
                .name(studentDto.getName())
                .sex(studentDto.getSex())
                .dateOfBirth(studentDto.getDateOfBirthInLDT())
                .age(studentDto.getAge())
                .legal(studentDto.isLegal())
                .build();
        //@formatter:on
	}
}