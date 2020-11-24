package io.learnstuff.mvc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@SuppressWarnings("serial")
public class Artist implements Serializable {

  private Long id;
  private String name = "";
  private String origin = "";
  private String details = "";
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date launchDate = new Date();
  private List<Album> albums;
  private Set<Gender> genders;

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

  public Set<Gender> getGenders() {
    return genders;
  }

  public void setGenders(Set<Gender> genders) {
    this.genders = genders;
  }

}
