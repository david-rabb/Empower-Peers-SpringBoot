package com.empowerpeers.service;

import com.empowerpeers.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Spring 4 JSON REST Service for Courses
 * @author Dave
 */
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CourseRepository courseRepository;
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    @Autowired
    public void setCourseRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/")
    public Iterable<Course> list(Authentication auth) {
        //return courseRepository.findAll();
        User user = userRepository.findByEmail(auth.getName());
        return courseRepository.listForStudent(user.getId());
    }
  
    @RequestMapping(method=RequestMethod.GET, value="/{id}")
    public Course get(@PathVariable int id){
        return courseRepository.findOne(id);
    }
  
}
