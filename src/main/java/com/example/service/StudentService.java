package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student document) {
		return studentRepository.save(document);
	}

	public Student getStudentById(String id) {
		return studentRepository.findById(id).orElse(null);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student updateStudent(Student student) {
		if (ObjectUtils.isEmpty(student) || ObjectUtils.isEmpty(student.getId())) {
			return null;
		}
		Student model = new Student();
		model.setId(student.getId());
		if (!ObjectUtils.isEmpty(student.getName())) {
			model.setName(student.getName());
		}
		if (!ObjectUtils.isEmpty(student.getEmail())) {
			model.setEmail(student.getEmail());
		}
		if (!ObjectUtils.isEmpty(student.getDepartment())) {
			model.setDepartment(student.getDepartment());
		}
		if (!ObjectUtils.isEmpty(student.getSubjects())) {
			model.setSubjects(student.getSubjects());
		}
		return studentRepository.save(model);
	}

	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "Student has been deleted!";
	}

}
