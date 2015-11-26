package com.empowerpeers;

import com.empowerpeers.entity.User;
import com.empowerpeers.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Configuration for how users are authenticated.
 * In this case, by user's email address and BCrypt encrypted password
 * @author Dave
 */
@Configuration
public class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
  
  @Autowired
  UserRepository userRepository;

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    //System.out.println("AuthenticationConfiguration.init");
    auth.userDetailsService(userDetailsService())
        .passwordEncoder(passwordEncoder());
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
  @Bean
  UserDetailsService userDetailsService() {
    return new UserDetailsService() {

      @Override
      public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        //System.out.println("loadUserByUsername"+user);
        if(user != null) {
          return user.getAuthentication();
        } else {
          throw new UsernameNotFoundException("could not find the user '" + email + "'");
        }
      }
      
    };
  }

}
