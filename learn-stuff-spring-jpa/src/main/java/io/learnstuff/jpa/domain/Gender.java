package io.learnstuff.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vlad Ungureanu
 */
@Entity
@Table(name = "sbs_genders")
public class Gender implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "sbs_genders_id_seq", sequenceName = "sbs_genders_id_seq",
            allocationSize = 1)
    private Long id;
    //
    @Column(name = "name")
    private String name = "";
    //
    @Column(name = "description")
    private String description = "";
    //
    @Column(name = "artist_origin")
    private String artistOrigin = "";
    //
    @Column(name = "cultural_origin")
    private String culturalOrigin = "";
    //
    @Column(name = "first_appeared_in")
    private Date firstAppearedIn = new Date();

}
