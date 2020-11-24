package io.learnstuff.repository;

import org.springframework.stereotype.Repository;
import io.learnstuff.jpa.domain.Artist;
import io.learnstuff.jpa.repository.AbstractDAO;


@Repository
public class ArtistDAO extends AbstractDAO<Artist> {

  protected ArtistDAO() {
    super(Artist.class);
  }
}
