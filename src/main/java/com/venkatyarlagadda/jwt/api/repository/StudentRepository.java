package com.venkatyarlagadda.jwt.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venkatyarlagadda.jwt.api.entity.Student;

/**
 * 
 * @author Venkat Yarlagadda
 * @version V1
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
