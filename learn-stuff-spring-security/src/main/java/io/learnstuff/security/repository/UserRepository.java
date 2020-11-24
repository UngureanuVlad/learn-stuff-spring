package io.learnstuff.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import io.learnstuff.security.domain.auth.User;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  @Modifying
  @Transactional
  @Query("update User u set activated = ?1 where id = ?2")
  int updateStatus(Boolean status, Long id);

  boolean existsByUsername(String username);

  boolean existsByEmail(String email);

  Optional<User> findByEmail(String email);

  String findEmailById(Long id);

}
