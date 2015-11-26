package com.empowerpeers;

/**
 * 
 * @author Dave
 */
import com.empowerpeers.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class StartupScripts implements CommandLineRunner {
    /*
    private UserRepository userRepository;
 
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
      this.userRepository = userRepository;
      System.out.println("StartupScripts.init");
    }
    */
    @Override
    public void run(String... args) {
      System.out.println("Running StartupScripts");
      /*
      User u = new User();
      u.setEmail("spring");
      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
      long t1 = System.currentTimeMillis();
      u.setPassword(bCryptPasswordEncoder.encode("spring"));
      long t2 = System.currentTimeMillis();
      System.out.println("BCryptPasswordEncoder "+(t2-t1)+"ms");
      userRepository.save(u);
      for (int i=8; i<17; i++) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        long t1 = System.currentTimeMillis();
        bCryptPasswordEncoder.encode("spring");
        long t2 = System.currentTimeMillis();
        System.out.println("BCryptPasswordEncoder "+i+": "+(t2-t1)+"ms");
      }
      */
    }

}