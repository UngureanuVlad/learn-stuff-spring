package io.learnstuff.ioc.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vlad Ungureanu
 */
@Data
public class Album implements Serializable {


    private Long id;
    private String title = "";
    private Date releaseDate = new Date();
    private Artist artist;


}
