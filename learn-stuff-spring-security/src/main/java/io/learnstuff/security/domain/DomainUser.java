package io.learnstuff.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DomainUser {

    private Long id;
    private String fullname;
    private String password;
    private String passwordRetype;
    private String email;
    private String phone;
    private String country;
    private String timezone;
    private String profileImage;
    private String detailsRO;
    private String detailsEN;
    private boolean acceptTerms;
    private boolean acceptGdpr;
    private boolean active;
    private boolean emailValidated;
    private boolean admin;
    private boolean guest;
}
