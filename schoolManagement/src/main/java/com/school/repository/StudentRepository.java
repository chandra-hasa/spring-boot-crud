package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.school.entity.StudentEntity;
import com.school.pojo.StudentPojo;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
	@Query("SELECT sd FROM stud_db sd WHERE stud_db.studentName LIKE %?1% and stud_db.age> ?2 ")
	List<StudentPojo> search(String studentName,int age);
	
	
	

}
