package com.empowerpeers;

/**
 * Bootstrap the Application
 * Optional init scripts in CommandLineRunner
 * @author Dave
 */
import com.empowerpeers.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {
    @Autowired
    UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class); 
	}
    
    @Bean
    CommandLineRunner init(final UserRepository userRepository) {
      return new CommandLineRunner() {
        @Override
        public void run(String... arg0) throws Exception {
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
      };
    }    
}