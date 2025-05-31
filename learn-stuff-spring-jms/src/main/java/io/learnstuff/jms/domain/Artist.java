package io.learnstuff.jms.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Vlad Ungureanu
 */
@Data
public class Artist implements Serializable {

    private Long id;
    private String name = "";
    private String origin = "";
    private String details = "";
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date launchDate = new Date();
    private List<Album> albums;
    private Set<Gender> genders;


}
