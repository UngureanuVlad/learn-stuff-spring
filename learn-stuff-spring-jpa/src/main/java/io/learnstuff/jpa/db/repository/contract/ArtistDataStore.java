package io.learnstuff.jpa.db.repository.contract;

import io.learnstuff.jpa.domain.Artist;

import java.util.List;

/**
 * @author Vlad Ungureanu
 */
public interface ArtistDataStore {

    /**
     * @param artist
     */
    void storeArtist(Artist artist);

    /**
     * @return
     */
    List<Artist> readArtist();
}
