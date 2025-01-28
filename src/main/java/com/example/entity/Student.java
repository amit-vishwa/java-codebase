package com.example.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student")
public class Student {

	@Id // this is for PK
	private String id;
	private String name;
	private String email;
	private Department department;
	private List<Subject> subjects;

	@Transient // this will get ignored while save and update operations
	private double percentage;

	public double getPercentage() {
		if (subjects.size() > 0) {
			int sum = subjects.stream().map(Subject::getMarksObtained).reduce(0, Integer::sum);
			return sum / subjects.size();
		}
		return 0.00;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Student() {
		super();
	}

	public Student(String id, Department department) {
		super();
		this.id = id;
		this.department = department;
	}

	// this was required for MongoDB where entity having more than one constructor,
	// on any one constructor
	@PersistenceConstructor
	public Student(String id, String name, String email, Department department, List<Subject> subjects) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.subjects = subjects;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}
