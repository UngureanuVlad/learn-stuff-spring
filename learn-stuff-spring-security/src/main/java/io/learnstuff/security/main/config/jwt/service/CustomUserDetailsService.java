package io.learnstuff.security.main.config.jwt.service;

import java.util.Iterator;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import io.learnstuff.security.domain.auth.User;
import io.learnstuff.security.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @SuppressWarnings("unchecked")
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = this.userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
    System.out.println(user.getUsername());
    Iterator<SimpleGrantedAuthority> it =
        (Iterator<SimpleGrantedAuthority>) user.getAuthorities().iterator();
    while (it.hasNext()) {
      System.out.println(it.next().getAuthority());
    }
    return user;
  }
}
