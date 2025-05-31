package io.learnstuff.security.services;


import io.learnstuff.security.domain.DomainToken;
import io.learnstuff.security.domain.DomainUser;
import io.learnstuff.security.domain.DomainUserRegistration;

public interface AuthenticationService {
    void register(DomainUserRegistration domainUser);

    DomainToken login(DomainUser domainUser);

}
