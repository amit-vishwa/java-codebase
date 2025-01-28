package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentService.createStudent(student);
	}

	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable String id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/getAll")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("/getByName/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}

	@GetMapping("/getByNameAndEmail")
	public List<Student> getStudentByNameAndEmail(@RequestParam String name, @RequestParam String email) {
		return studentService.getStudentByNameAndEmail(name, email);
	}

	@GetMapping("/getByNameOrEmail")
	public List<Student> getStudentByNameOrEmail(@RequestParam String name, @RequestParam String email) {
		return studentService.getStudentByNameOrEmail(name, email);
	}

	@GetMapping("/getAllOnPage")
	public List<Student> getAllStudensOnPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
		return studentService.getAllStudentsOnPage(pageNo, pageSize).getContent();
	}

	@GetMapping("/getPage")
	public Page<Student> getStudensPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
		return studentService.getAllStudentsOnPage(pageNo, pageSize);
	}

	@GetMapping("/getSorted")
	public List<Student> getSortedStudens() {
		return studentService.getSortedStudents();
	}

	@GetMapping("/getByDepartmentName/{name}")
	public List<Student> getStudentsByDepartmentName(@PathVariable String name) {
		return studentService.getStudentsByDepartmentName(name);
	}

	@GetMapping("/getBySubjectName")
	public List<Student> getStudentsBySubjectName(@RequestParam String subjectName) {
		return studentService.getStudentsBySubjectName(subjectName);
	}

	@GetMapping("/getByEmailLike")
	public List<Student> getStudentsByEmailLike(@RequestParam String email) {
		return studentService.getStudentsByEmailLike(email);
	}

	@GetMapping("/getByNameStartingWith")
	public List<Student> getStudentsByNameStartingWith(@RequestParam String name) {
		return studentService.getStudentsByNameStartingWith(name);
	}

	@GetMapping("/getByDepartmentId/{departmentId}")
	public List<Student> getStudentByDepartmentName(@PathVariable String departmentId) {
		return studentService.getStudentByDepartmentId(departmentId);
	}

}
