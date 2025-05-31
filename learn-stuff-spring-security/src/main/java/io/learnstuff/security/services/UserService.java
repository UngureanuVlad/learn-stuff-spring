package io.learnstuff.security.services;

import io.learnstuff.security.domain.DomainUser;
import io.learnstuff.security.domain.auth.AuthorityTypes;
import io.learnstuff.security.domain.auth.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

    DomainUser getUserById(Long identifier);

    Optional<UserEntity> getUserByEmail(String userEmail);

    DomainUser updateProfile(DomainUser domainUser, Long identifier);

    boolean userHasRole(UserEntity userEntity, AuthorityTypes authorityTypes);
}
