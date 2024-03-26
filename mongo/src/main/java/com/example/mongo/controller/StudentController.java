package com.example.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.entity.Student;
import com.example.mongo.service.StudentService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/getAll")
	public Iterable<Student> getAllStudent(){
		return service.getAllStudents();
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student s) {
		service.addOrUpdateStudent(s);
		return s.getId();
	}
	
	@PutMapping("/edit/{id}")
	public Student updateStudent( @RequestBody Student s, 
									@PathVariable String id) {
		s.setName(s.getName());
		s.setEmail(s.getEmail());
		s.setMobile(s.getMobile());
		service.addOrUpdateStudent(s);
		return s;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudentById(@PathVariable String id) {
		service.deleteStudentById(id);
	}
	
	@RequestMapping("/get/{id}")
	public Student getStudentById(@PathVariable String id) {
		return service.findStudentById(id);
	}
}
