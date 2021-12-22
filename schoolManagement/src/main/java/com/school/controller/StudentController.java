package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.pojo.StudentPojo;
import com.school.service.StudentService;


@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/home")
	public String homePage() {
		return "Welcome!! This is Home Page";
	}
	
	@PostMapping(value="/save")
	public StudentPojo saveStudent(@RequestBody StudentPojo studentPojo) {
		studentPojo=studentService.saveStudent(studentPojo);
		return studentPojo;
	}
	
	@PostMapping(value="/student/{studentId}")
	public StudentPojo getStudent(@PathVariable("studentId") int studentId) {
		StudentPojo studentPojo=studentService.getStudent(studentId);
		return studentPojo;	
	}
	
	@GetMapping(value="/students")
	public List<StudentPojo> getAllStudents(){
		List<StudentPojo> studentPojoList= studentService.getAllStudents();
		return studentPojoList;
		
	}
	
	@GetMapping(value="/search")
	public List<StudentPojo> search(@RequestParam(name="studentName" ,required=false) String studentName,@RequestParam(name="age",required=false) int age){
		List<StudentPojo> studentPojoList= studentService.search(studentName, age);
		
		return studentPojoList;
	}
	
	@PutMapping(value="/students")
	public StudentPojo updateStudent(StudentPojo studentPojo){
		studentService.updateStudent(studentPojo);
		studentPojo=studentService.getStudent(studentPojo.getStudentId());
		return studentPojo;	
	}
	
	@DeleteMapping(value="/delete/{studentId}")
	public void deleteStudent(@PathVariable("studentId") int studentId) {
		studentService.deleteStudent(studentId);
		
	}
	
	
	
}
	