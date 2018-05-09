package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.service.CourseService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	private static final String COURSES_VIEW = "courses";

	@GetMapping("/listCourses")
	public ModelAndView listAllCourses(){
		LOG.info("Calling:" + "listAllCourses()");

		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("courses", courseService.listAllCourses());
		
		return mav;
	}
	
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") Course course ){
		LOG.info("Calling"+ "addCourse" + " Param: " + course.toString());
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		
		courseService.addCourse(course);
		
		return "redirect:/courses/listCourses";
	}
}
