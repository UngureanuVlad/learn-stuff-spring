package io.learnstuff.ioc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@SuppressWarnings("serial")
public class Album implements Serializable {


  private Long id;
  private String title = "";
  private Date releaseDate = new Date();
  private Artist artist;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Artist getArtist() {
    return artist;
  }

  public void setArtist(Artist artist) {
    this.artist = artist;
  }

}
