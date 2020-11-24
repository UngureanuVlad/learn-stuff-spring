package io.learnstuff.mvc.builders;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import io.learnstuff.mvc.domain.Album;
import io.learnstuff.mvc.domain.Artist;
import io.learnstuff.mvc.domain.Gender;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
public class ArtefactBuilder {

  public static Artist anArtist() {
    Artist artist = new Artist();
    artist.setName("Metallica");
    artist.setOrigin("Callifornia, USA");
    artist.setLaunchDate(new Date());
    artist.setGenders(genders());
    artist.setAlbums(albums());
    return artist;
  }

  public static Artist anArtistWithoutGenders() {
    Artist artist = new Artist();
    artist.setName("Metallica");
    artist.setOrigin("Callifornia, USA");
    artist.setLaunchDate(new Date());
    artist.setGenders(new HashSet<Gender>());
    artist.setAlbums(albums());
    return artist;
  }

  public static Artist anArtistWithId() {
    Artist artist = new Artist();
    artist.setId(1L);
    artist.setName("Metallica");
    artist.setOrigin("Callifornia, USA");
    artist.setLaunchDate(new Date());
    artist.setGenders(new HashSet<Gender>());
    artist.setAlbums(albums());
    return artist;
  }

  public static Album anAlbum() {
    Album album = new Album();
    album.setTitle("St. Anger");
    album.setReleaseDate(new Date());
    album.setArtist(anArtist());
    return album;
  }

  public static Album anAlbum(Artist artist) {
    Album album = new Album();
    album.setTitle("St. Anger");
    album.setReleaseDate(new Date());
    album.setArtist(anArtist());
    return album;
  }

  public static Gender aGender() {
    Gender gender = new Gender();
    // empty gender
    return gender;
  }

  public static List<Album> albums() {
    List<Album> albums = new ArrayList<Album>();

    return albums;
  }

  public static Set<Gender> genders() {
    Set<Gender> genders = new HashSet<Gender>();
    genders.add(aGender());
    return genders;
  }

  public static Set<Artist> artists() {
    Set<Artist> artists = new HashSet<Artist>();
    artists.add(anArtist());
    return artists;
  }

  public static List<Artist> multipleArtists() {
    List<Artist> artists = new ArrayList<Artist>();
    artists.add(anArtist("Metalica", anAlbum("St. Anger")));
    artists.add(anArtist("Iron Maiden", anAlbum("Fear of the dark")));
    artists.add(anArtist("AC/DC", anAlbum("Highway to Hell")));
    artists.add(anArtist("System of a down", anAlbum("Toxicity")));
    return artists;
  }

  public static List<Artist> multipleArtistsWithId() {
    List<Artist> artists = new ArrayList<Artist>();
    artists.add(anArtistWithId(1L, "Metalica", anAlbum("St. Anger")));
    artists.add(anArtistWithId(2L, "Iron Maiden", anAlbum("Fear of the dark")));
    artists.add(anArtistWithId(3L, "AC/DC", anAlbum("Highway to Hell")));
    artists.add(anArtistWithId(4L, "System of a down", anAlbum("Toxicity")));
    return artists;
  }

  /**
   * 
   * @param name
   * @param anAlbum
   * @return
   */
  public static Artist anArtist(String name, Album anAlbum) {
    Artist artist = new Artist();
    artist.setName(name);
    artist.setLaunchDate(new Date());
    artist.setGenders(genders());

    // albums
    List<Album> albums = new ArrayList<Album>();
    albums.add(anAlbum);

    artist.setAlbums(albums);
    return artist;
  }

  public static Artist anArtistWithId(Long id, String name, Album anAlbum) {
    Artist artist = new Artist();
    artist.setId(id);
    artist.setName(name);
    artist.setLaunchDate(new Date());
    artist.setGenders(genders());

    // albums
    List<Album> albums = new ArrayList<Album>();
    albums.add(anAlbum);

    artist.setAlbums(albums);
    return artist;
  }

  /**
   * <p>
   * Returns an instance of an album.
   * </p>
   * <p>
   * <b>Note:</b> the returned instance it will not have an artist associated with the album. It is
   * used for display purposes.
   * </p>
   * 
   * @param title
   * @return
   */
  public static Album anAlbum(String title) {
    Album album = new Album();
    album.setTitle(title);
    album.setReleaseDate(new Date());
    return album;
  }
}
