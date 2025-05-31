package io.learnstuff.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Vlad Ungureanu
 */
@Entity
@Table(name = "sbs_artists")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "sbs_artists_id_seq", sequenceName = "sbs_artists_id_seq",
            allocationSize = 1)
    private Long id;
    //
    @Column(name = "name")
    private String name = "";
    //
    @Column(name = "origin")
    private String origin = "";
    //
    @Column(name = "details")
    private String details = "";
    //
    @Column(name = "launch_date")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date launchDate = new Date();
    //
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artist")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Album> albums;
    //
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "sbs_artist_genders", joinColumns = @JoinColumn(name = "id_artist"),
            inverseJoinColumns = @JoinColumn(name = "id_gender"))
    private List<Gender> genders = new ArrayList<Gender>();

}
