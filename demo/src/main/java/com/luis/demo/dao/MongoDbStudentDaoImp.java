package com.luis.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.luis.demo.model.Student;
import com.luis.demo.dao.StudentDao;

@Repository("mongoDbDao")
public class MongoDbStudentDaoImp implements StudentDao {

//	bean to manage the db
//	private final MongoDbTemplate mongoDbTemplate;
	
	@Override
	public int insertNewStudent(UUID studentId, Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student selectStudentByUUID(UUID studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> selectAllStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(UUID.randomUUID(), 30, "Paulina", "Glz", "Kinder"));
		return students;
	}

	@Override
	public int updateStudentById(UUID studentId, Student studentUpdate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStudentById(UUID studentId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
