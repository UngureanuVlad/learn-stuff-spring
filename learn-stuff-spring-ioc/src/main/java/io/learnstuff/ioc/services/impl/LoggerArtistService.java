package io.learnstuff.ioc.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import io.learnstuff.ioc.builders.ArtefactBuilder;
import io.learnstuff.ioc.domain.Artist;
import io.learnstuff.ioc.main.ConsoleApplication;
import io.learnstuff.ioc.services.contracts.AlbumService;
import io.learnstuff.ioc.services.contracts.ArtistService;

@Service
public class LoggerArtistService implements ArtistService {

  @Autowired
  // @Qualifier("consoleAlbumService")
  @Qualifier("loggerAlbumService")
  AlbumService albumService;

  public Artist readArtist() {
    return ArtefactBuilder.anArtist();
  }

  public void showArtist(Artist artist) {
    ConsoleApplication.logger.info("The artist we read: " + readArtist().getName());
    ConsoleApplication.logger
        .info("The album we read from an injected service: " + albumService.readAlbum().getTitle());
  }

}
