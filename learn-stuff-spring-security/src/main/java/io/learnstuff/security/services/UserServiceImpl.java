package io.learnstuff.security.services;

import io.jsonwebtoken.security.SecurityException;
import io.learnstuff.security.domain.DomainUser;
import io.learnstuff.security.domain.auth.AuthorityTypes;
import io.learnstuff.security.domain.auth.UserEntity;
import io.learnstuff.security.exception.types.BusinessException;
import io.learnstuff.security.exception.types.ValidationException;
import io.learnstuff.security.repository.UserRepository;
import io.learnstuff.security.services.mappers.UserMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapperService userMapperService;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    @Override
    public DomainUser getUserById(Long identifier) {
        Optional<UserEntity> userEntity = this.userRepository.findById(identifier);
        if (userEntity.isPresent()) {
            return this.userMapperService.mapEntityToDomain(userEntity.get());
        } else {
            throw new SecurityException("User not found!");
        }
    }

    @Override
    public Optional<UserEntity> getUserByEmail(String userEmail) {
        return this.userRepository.findByEmail(userEmail);
    }

    @Override
    public DomainUser updateProfile(DomainUser domainUser, Long identifier) {
        if (domainUser.getId() == null || domainUser.getId() <= 0 || !identifier.equals(domainUser.getId())) {
            throw new ValidationException("User not found!");
        }
        if (domainUser.getId() > 0) {
            Optional<UserEntity> userEntity = this.userRepository.findById(domainUser.getId());
            if (userEntity.isPresent()) {
                String passwordBackup = userEntity.get().getPassword();
                boolean active = userEntity.get().isActive();
                BeanUtils.copyProperties(domainUser, userEntity.get());
                if ((domainUser.getPassword() != null && StringUtils.hasText(domainUser.getPassword()))
                        || (domainUser.getPasswordRetype() != null && StringUtils.hasText(domainUser.getPasswordRetype()))) {
                    userEntity.get().setPassword(domainUser.getPassword());
                } else {
                    userEntity.get().setPassword(passwordBackup);
                }
                // update
                userEntity.get().setActive(active);
                this.userRepository.save(userEntity.get());
                return this.userMapperService.mapEntityToDomain(userEntity.get());
            } else {
                throw new BusinessException("User not found!");
            }
        } else {
            throw new BusinessException("User not found!");
        }
    }

    @Override
    public boolean userHasRole(UserEntity userEntity, AuthorityTypes authorityType) {
        return userEntity.getAuthorities().stream()
                .anyMatch((grantedAuthority -> grantedAuthority.getAuthority().equalsIgnoreCase(authorityType.name())));
    }
}
