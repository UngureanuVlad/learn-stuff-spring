package io.learnstuff.security.repository;

import io.learnstuff.security.domain.auth.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    @Modifying
    @Transactional
    @Query("UPDATE UserEntity u SET u.active = true WHERE u.id = ?1")
    void activateUser(Long id);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users_authorities WHERE user_id = ?1", nativeQuery = true)
    void deleteAuthoritiesForUserId(Long userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users_authorities SET authority_id = ?2 WHERE user_id = ?1", nativeQuery = true)
    void updateAuthority(Long userId, Long authorityId);
}
