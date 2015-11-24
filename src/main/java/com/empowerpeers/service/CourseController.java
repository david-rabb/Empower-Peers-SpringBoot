package com.empowerpeers.service;

import com.empowerpeers.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Spring 4 JSON REST Service for Courses
 * @author Dave
 */
@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseRepository courseRepository;
 
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/")
    public Iterable<Course> list() {
        return courseRepository.findAll();
    }
  
    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public Course get(@PathVariable long id){
        return courseRepository.findOne(id);
    }
  
}
