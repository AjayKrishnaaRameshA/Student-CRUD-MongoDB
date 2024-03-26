package com.example.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongo.entity.Student;
import com.example.mongo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	public StudentRepository repository;
	
	public String addOrUpdateStudent(Student s) {
		repository.save(s);
		return s.getId();
	}
	
	public Iterable<Student> getAllStudents(){
		return repository.findAll();
	}
	
	public Student findStudentById(String id) {
		return repository.
				findById(id).
				orElseThrow(()->new RuntimeException("student not found"));
	}
	
	public void deleteStudentById(String id) {
		repository.deleteById(id);
	}
	
	
}
