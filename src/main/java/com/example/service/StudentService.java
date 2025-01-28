package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.entity.Student;
import com.example.repository.DepartmentRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;

@Service
public class StudentService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	public Student createStudent(Student document) {
		if (document.getDepartment() != null) {
			departmentRepository.save(document.getDepartment());
		}
		if (document.getSubjects() != null && document.getSubjects().size() > 0) {
			subjectRepository.saveAll(document.getSubjects());
		}
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
		if (!ObjectUtils.isEmpty(student.getPercentage())) {
			model.setPercentage(student.getPercentage());
		}
		return studentRepository.save(model);
	}

	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "Student has been deleted!";
	}

	public List<Student> getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	public List<Student> getStudentByNameAndEmail(String name, String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	public List<Student> getStudentByNameOrEmail(String name, String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	public Page<Student> getAllStudentsOnPage(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize); // page no is 0 based
		return studentRepository.findAll(pageable);
	}

	public List<Student> getSortedStudents() {
		// multiple fields can be passed
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		return studentRepository.findAll(sort);
	}

	public List<Student> getStudentsByDepartmentName(String name) {
		return studentRepository.findByDepartmentDepartmentName(name);
	}

	public List<Student> getStudentsBySubjectName(String subjectName) {
		return studentRepository.findBySubjectsSubjectName(subjectName);
	}

	public List<Student> getStudentsByEmailLike(String email) {
		return studentRepository.findByEmailIsLike(email);
	}

	public List<Student> getStudentsByNameStartingWith(String name) {
		return studentRepository.findByNameStartsWith(name);
	}

	public List<Student> getStudentByDepartmentId(String departmentId) {
		return studentRepository.findByDepartmentId(departmentId);
	}

}
