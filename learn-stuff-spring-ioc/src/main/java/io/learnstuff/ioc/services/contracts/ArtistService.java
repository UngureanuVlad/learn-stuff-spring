package io.learnstuff.ioc.services.contracts;

import io.learnstuff.ioc.domain.Artist;

public interface ArtistService {

  /**
   * <p>
   * Reads an artist from an outside source.
   * </p>
   * 
   * @return
   */
  public Artist readArtist();

  /**
   * <p>
   * Display an artist.
   * </p>
   * 
   * @param artist
   */
  public void showArtist(Artist artist);
}
