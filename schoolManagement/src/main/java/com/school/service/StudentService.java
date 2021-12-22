package com.school.service;

import java.util.List;


import com.school.pojo.StudentPojo;

public interface StudentService {

	StudentPojo saveStudent(StudentPojo studentPojo);
	
	StudentPojo getStudent(int studentId);
	
	List<StudentPojo> getAllStudents();
	
	void updateStudent(StudentPojo studentPojo);
	
	void deleteStudent(int studentId);
	
	List<StudentPojo> search(String studentName,int age);
	

}
