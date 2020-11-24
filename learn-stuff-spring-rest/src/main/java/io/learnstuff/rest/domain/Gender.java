package io.learnstuff.rest.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@SuppressWarnings("serial")
public class Gender implements Serializable {

  private Long id;
  private String name = "";
  private String description = "";
  private String artistOrigin = "";
  private String culturalOrigin = "";
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
