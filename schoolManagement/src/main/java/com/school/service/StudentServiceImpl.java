package com.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.StudentEntity;
import com.school.pojo.StudentPojo;
import com.school.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentPojo saveStudent(StudentPojo studentPojo) {
		
		StudentEntity student = new StudentEntity();
		student.setStudentId(studentPojo.getStudentId());
		student.setStudentName(studentPojo.getStudentName());
		student.setAge(studentPojo.getAge());
		
		
		studentRepository.save(student);
		
		return studentPojo;
	}

	@Override
	public StudentPojo getStudent(int studentId) {
		
		StudentEntity student = studentRepository.getById(studentId);
		StudentPojo studentPojo = new StudentPojo();
		studentPojo.setStudentId(student.getStudentId());
		studentPojo.setAge(student.getAge());
		studentPojo.setStudentId(student.getStudentId());
		
		return studentPojo;
	}
	@Override
	public List<StudentPojo> getAllStudents() {
		List<StudentPojo> studentPojoList = new ArrayList<StudentPojo>();
		List<StudentEntity> studentEntityList= studentRepository.findAll();
		
		for(StudentEntity studentEntity : studentEntityList) {
			StudentPojo studentPojo = new StudentPojo();
			studentPojo.setStudentId(studentEntity.getStudentId());
			studentPojo.setStudentName(studentEntity.getStudentName());
			studentPojo.setAge(studentEntity.getAge());
			
			studentPojoList.add(studentPojo);
		}
		return studentPojoList;
	}
	@Override
	public void updateStudent(StudentPojo studentPojo) {
		StudentEntity student= studentRepository.getById(studentPojo.getStudentId());
		student.setStudentId(studentPojo.getStudentId());
		student.setAge(studentPojo.getAge());
		student.setStudentName(studentPojo.getStudentName());
		
		System.out.println("Update successful");
		
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
		
		
	}
	
	@Override
	public List<StudentPojo> search(String studentName,int age) {
		List<StudentPojo> list =studentRepository.search(studentName,age);
		return list;
	}

	}


