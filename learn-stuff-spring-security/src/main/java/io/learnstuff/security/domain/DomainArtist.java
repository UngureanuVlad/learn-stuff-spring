package io.learnstuff.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vlad Ungureanu
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DomainArtist implements Serializable {

    private Long id;
    private String name = "";
    private String origin = "";
    private String details = "";
    private Date launchDate = new Date();

}
