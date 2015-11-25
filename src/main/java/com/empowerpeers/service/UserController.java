package com.empowerpeers.service;

import com.empowerpeers.entity.*;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * Spring 4 JSON REST Service for Users
 * @author Dave
 */
@RestController
public class UserController {
  
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
}
