package io.learnstuff.jpa.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "sbs_albums")
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
