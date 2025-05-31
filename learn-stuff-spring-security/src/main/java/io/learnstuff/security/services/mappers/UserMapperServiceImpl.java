package io.learnstuff.security.services.mappers;

import io.learnstuff.security.domain.DomainUser;
import io.learnstuff.security.domain.auth.AuthorityTypes;
import io.learnstuff.security.domain.auth.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserMapperServiceImpl implements UserMapperService {

    @Override
    public DomainUser mapEntityToDomain(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        DomainUser domainUser = new DomainUser();
        BeanUtils.copyProperties(userEntity, domainUser);
        domainUser.setPassword("");
        processDomainUser(domainUser, userEntity.getAuthorities());
        return domainUser;
    }

    @Override
    public UserEntity mapDomainToEntity(DomainUser domainUser) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(domainUser, userEntity);
        if (domainUser.getId() != null && domainUser.getId() <= 0) {
            userEntity.setId(null);
        } else {
            userEntity.setId(domainUser.getId());
        }
        return userEntity;
    }

    @Override
    public List<DomainUser> mapEntityListToDomainList(List<UserEntity> userEntityList) {
        if (userEntityList != null) {
            return userEntityList.stream().map(this::mapEntityToDomain).collect(Collectors.toList());
        } else {
            return List.of();
        }
    }

    private void processDomainUser(DomainUser domainUser, Collection<GrantedAuthority> authorities) {
        domainUser.setPassword("");
        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals(AuthorityTypes.ADMIN.name()))) {
            domainUser.setAdmin(true);
        }
        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals(AuthorityTypes.USER.name()))) {
            domainUser.setAdmin(false);
        }
        if (authorities.stream().anyMatch(authority -> authority.getAuthority().equals(AuthorityTypes.GUEST.name()))) {
            domainUser.setGuest(true);
        }
    }
}
