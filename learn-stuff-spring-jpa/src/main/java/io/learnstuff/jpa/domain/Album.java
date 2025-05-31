package io.learnstuff.jpa.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vlad Ungureanu
 */
@Entity
@Table(name = "sbs_albums")
@Data
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "sbs_albums_id_seq", sequenceName = "sbs_albums_id_seq",
            allocationSize = 1)
    private Long id;
    //
    @Column(name = "title")
    private String title = "";
    //
    @Column(name = "release_date")
    private Date releaseDate = new Date();
    //
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_artist")
    private Artist artist;

}
