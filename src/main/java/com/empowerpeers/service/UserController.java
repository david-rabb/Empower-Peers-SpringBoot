package com.empowerpeers.service;

import com.empowerpeers.entity.*;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
/**
 * Spring 4 JSON REST Service for Users
 * @author Dave
 */
@RestController
public class UserController {
  private UserRepository userRepository;

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
      this.userRepository = userRepository;
  }
  
  @RequestMapping("/api/user")
  public User user(Authentication auth) {
    long t1 = System.currentTimeMillis();
    User user = userRepository.findByEmail(auth.getName());
    long t2 = System.currentTimeMillis();
    //UserDetails user = (User)auth.getPrincipal();
    System.out.println("userRepository.findByEmail: "+(t2-t1)+"ms");
    return user;
  }
}
