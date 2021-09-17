package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentService;
	
	public StudentService(StudentRepository studentservice) {
		this.studentService = studentservice;
	}
	
	public List<Student>getAllStudents(){
		return this.studentService.findAll();
	}
	
	public Student getSingleStudent(Long id) {
		return this.studentService.findById(id).orElse(null);
	}
	
	public Student createStudent(Student newStudent) {
		return this.studentService.save(newStudent);
	}
	
	public void deleteStudent(Long id) {
		this.studentService.deleteById(id);
	}
	
	public Student updateStudent(Student student) {
		return this.studentService.save(student);
	}
}
