package io.learnstuff.security.services.mappers;


import io.learnstuff.security.domain.DomainUser;
import io.learnstuff.security.domain.auth.UserEntity;

import java.util.List;

public interface UserMapperService {
    DomainUser mapEntityToDomain(UserEntity userEntity);

    UserEntity mapDomainToEntity(DomainUser domainUser);

    List<DomainUser> mapEntityListToDomainList(List<UserEntity> allNotActive);
}
