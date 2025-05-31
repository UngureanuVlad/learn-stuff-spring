package io.learnstuff.security.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DomainResponse {
    private String message;
}
