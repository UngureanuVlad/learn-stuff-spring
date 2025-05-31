package io.learnstuff.mvc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vlad Ungureanu
 */
@Data
public class Gender implements Serializable {

    private Long id;
    private String name = "";
    private String description = "";
    private String artistOrigin = "";
    private String culturalOrigin = "";
    private Date firstAppearedIn = new Date();

}
