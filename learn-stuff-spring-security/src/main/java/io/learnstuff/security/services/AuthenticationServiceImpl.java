package io.learnstuff.security.services;

import io.learnstuff.security.domain.DomainToken;
import io.learnstuff.security.domain.DomainUser;
import io.learnstuff.security.domain.DomainUserRegistration;
import io.learnstuff.security.domain.auth.UserEntity;
import io.learnstuff.security.exception.types.BusinessException;
import io.learnstuff.security.repository.UserRepository;
import io.learnstuff.security.services.mappers.UserMapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapperService userMapperService;

    @Override
    @Transactional
    public void register(DomainUserRegistration domainUserRegistration) {
        try {
            UserEntity user = this.userMapperService.mapDomainToEntity(domainUserRegistration.getDomainUser());
            processNewUser(user);
            userRepository.save(user);
        } catch (Exception e) {
            throw new BusinessException("Registration failed!");
        }
    }

    @Override
    public DomainToken login(DomainUser request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException("Invalid credentials"));
        var jwt = jwtService.generateToken(user);
        return DomainToken.builder().token(jwt).build();
    }

    private void processNewUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setId(null);
        user.setActive(false);
    }
}
