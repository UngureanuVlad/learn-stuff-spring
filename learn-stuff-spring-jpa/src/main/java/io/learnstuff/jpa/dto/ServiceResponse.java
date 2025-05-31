package io.learnstuff.jpa.dto;

import lombok.Data;

@Data
public class ServiceResponse {

    private String message = "Operation Succesfull!";
    private int code = 200;
}
