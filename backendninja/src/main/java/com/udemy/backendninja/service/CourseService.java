package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Course;

public interface CourseService {
	
	public Course findCourse(Course course);
	
	public List<Course> listAllCourses();
	
	public void addCourse(Course course);
	
	public int removeCourse(int id);
	
	public Course updateCourse(Course course);
	
}
