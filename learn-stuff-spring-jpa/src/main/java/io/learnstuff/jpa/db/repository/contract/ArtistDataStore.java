package io.learnstuff.jpa.db.repository.contract;

import java.util.List;
import io.learnstuff.jpa.domain.Artist;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
public interface ArtistDataStore {

  /**
   * 
   * @param artist
   */
  void storeArtist(Artist artist);

  /**
   * 
   * @return
   */
  List<Artist> readArtist();
}
