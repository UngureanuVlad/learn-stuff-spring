package io.learnstuff.rest.dto;

import lombok.Data;

@Data
public class ServiceResponse {

    private String message = "Operation Successful!";
    private int code = 200;

}
