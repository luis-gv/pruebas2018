package com.luis.demo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.luis.demo.dao.StudentDao;
import com.luis.demo.model.Student;

@Service
public class StudentService {
	
	private StudentDao studentDao;
	
	@Autowired
	public StudentService(@Qualifier("mongoDbDao") StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public int persistNewStudent(Student student) {
		UUID studentUuid = UUID.randomUUID();
		student.setId(studentUuid);
		return studentDao.insertNewStudent(studentUuid, student);
	}
	
	public Student getStudentByUUID(UUID studentId) {
		return studentDao.selectStudentByUUID(studentId);
	}
	
	public List<Student> getAllStudents(){
		return studentDao.selectAllStudents();
	}
	
	public int updateStudentById(UUID studentId, Student studentUpdate){
		return studentDao.updateStudentById(studentId, studentUpdate);
	}
	
	public int deleteStudentById(UUID studentId) {
//		Student student = getStudentByUUID(studentId);
//		if(student == null) {
//			return 1;
//		}
		return studentDao.deleteStudentById(studentId);
	}
}
