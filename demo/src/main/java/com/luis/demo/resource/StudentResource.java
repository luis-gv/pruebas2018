package com.luis.demo.resource;

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luis.demo.model.Student;
import com.luis.demo.service.StudentService;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {
	
	private final StudentService studentService;
	private Logger log = Logger.getLogger(StudentResource.class);

	@Autowired
	public StudentResource(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public List<Student> getAllStudents(){
		log.debug("Obteniendo todos los estudiantes");
		return studentService.getAllStudents();
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			path = "{studentId}")
	public Student getStudentById(@PathVariable("studentId") UUID studentId) {
		log.debug("Un estudiante por su id");
		return studentService.getStudentByUUID(studentId);
	}
	
	@RequestMapping(
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Student createStudent(@RequestBody Student student) {
		studentService.persistNewStudent(student);
		return student;
	}
	
	@RequestMapping(
			method=RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			path = "{studentId}")
	public Student updateStudent(@PathVariable("studentId") UUID studentId, @RequestBody Student studentUpdate) {
		studentUpdate.setId(studentId);
		studentService.updateStudentById(studentId, studentUpdate);
		return studentUpdate;
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE,
			path = "{studentId}")
	public void deleteStudent(@PathVariable UUID studentId){
		studentService.deleteStudentById(studentId);
	}
	
}
