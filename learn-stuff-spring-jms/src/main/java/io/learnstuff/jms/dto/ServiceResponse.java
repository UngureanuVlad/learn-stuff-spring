package io.learnstuff.jms.dto;

import lombok.Data;

/**
 * @author Vlad Ungureanu
 */
@Data
public class ServiceResponse {

    private String message = "Operation Succesfull!";
    private int code = 200;

}
