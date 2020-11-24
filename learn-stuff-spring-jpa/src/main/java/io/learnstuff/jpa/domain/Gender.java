package io.learnstuff.jpa.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@SuppressWarnings("serial")
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getArtistOrigin() {
    return artistOrigin;
  }

  public void setArtistOrigin(String artistOrigin) {
    this.artistOrigin = artistOrigin;
  }

  public String getCulturalOrigin() {
    return culturalOrigin;
  }

  public void setCulturalOrigin(String culturalOrigin) {
    this.culturalOrigin = culturalOrigin;
  }

  public Date getFirstAppearedIn() {
    return firstAppearedIn;
  }

  public void setFirstAppearedIn(Date firstAppearedIn) {
    this.firstAppearedIn = firstAppearedIn;
  }

}
