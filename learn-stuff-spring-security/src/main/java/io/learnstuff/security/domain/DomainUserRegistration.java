package io.learnstuff.security.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomainUserRegistration {

    private DomainUser domainUser;
    private String presentationVideo;

}
