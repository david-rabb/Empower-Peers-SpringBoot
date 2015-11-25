package com.empowerpeers.entity;

import org.springframework.data.repository.CrudRepository;

/**
 * Basic Crud Repository for Users
 * @author Dave
 */
public interface UserRepository extends CrudRepository<User, Long> {
  public User findByEmail(String email);
}