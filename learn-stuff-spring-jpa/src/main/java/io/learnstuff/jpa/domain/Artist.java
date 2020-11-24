package io.learnstuff.jpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.learnstuff.jpa.domain.serializers.LaunchDateSerializer;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sbs_artists")
@JsonIgnoreProperties(ignoreUnknown = true)
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  @JsonSerialize(using = LaunchDateSerializer.class)
  public Date getLaunchDate() {
    return launchDate;
  }

  public void setLaunchDate(Date launchDate) {
    this.launchDate = launchDate;
  }

  public List<Album> getAlbums() {
    return albums;
  }

  public void setAlbums(List<Album> albums) {
    this.albums = albums;
  }

  public List<Gender> getGenders() {
    return genders;
  }

  public void setGenders(List<Gender> genders) {
    this.genders = genders;
  }
}
