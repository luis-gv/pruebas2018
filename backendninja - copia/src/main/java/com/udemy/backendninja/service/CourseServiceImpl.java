package com.udemy.backendninja.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.controller.CourseController;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.repository.CourseJpaRepository;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public Course findCourse(Course course) {
		return courseJpaRepository.findOne(course.getId());
	}

	@Override
	public List<Course> listAllCourses() {
		LOG.info("Calling: listAllCourses()");
		return courseJpaRepository.findAll();
	}

	@Override
	public void addCourse(Course course) {
		LOG.info("Calling: addCourse()");
		courseJpaRepository.save(course);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.delete(id);
		return id;
	}

	@Override
	public Course updateCourse(Course course) {
		courseJpaRepository.save(course);
		return courseJpaRepository.findOne(course.getId()) ;
	}

}
