package com.empowerpeers.entity;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Basic Crud Repository for Courses
 * @author Dave
 */
public interface CourseRepository extends CrudRepository<Course, Integer> {
  
  @Query(value="select c.* from course c, user_course uc where uc.courseid=c.id and uc.role='STUDENT' and uc.userid=?1", nativeQuery=true)
  public List<Course> listForStudent(int userId);
}