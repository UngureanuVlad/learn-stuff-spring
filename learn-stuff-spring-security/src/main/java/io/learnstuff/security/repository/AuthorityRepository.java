package io.learnstuff.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import io.learnstuff.security.domain.auth.Authority;

@Transactional
public interface AuthorityRepository   extends JpaRepository<Authority, Long> {
  
  Optional<Authority> findByName(String name);

}
