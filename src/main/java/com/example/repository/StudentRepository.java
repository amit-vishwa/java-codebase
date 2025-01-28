package com.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByName(String name);

	List<Student> findByNameAndEmail(String name, String email);

	List<Student> findByNameOrEmail(String name, String email);

	List<Student> findByDepartmentDepartmentName(String name);

	List<Student> findBySubjectsSubjectName(String name);

	List<Student> findByEmailIsLike(String email);

	List<Student> findByNameStartsWith(String name);
//	List<Student> findByNameStartingWith(String name); // similar to above

}
