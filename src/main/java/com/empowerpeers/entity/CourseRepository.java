package com.empowerpeers.entity;

import org.springframework.data.repository.CrudRepository;

/**
 * Basic Crud Repository for Courses
 * @author Dave
 */
public interface CourseRepository extends CrudRepository<Course, Integer> {
}