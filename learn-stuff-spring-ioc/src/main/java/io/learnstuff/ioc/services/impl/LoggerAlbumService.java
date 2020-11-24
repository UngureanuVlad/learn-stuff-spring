package io.learnstuff.ioc.services.impl;

import org.springframework.stereotype.Service;
import io.learnstuff.ioc.builders.ArtefactBuilder;
import io.learnstuff.ioc.domain.Album;
import io.learnstuff.ioc.main.ConsoleApplication;
import io.learnstuff.ioc.services.contracts.AlbumService;

@Service("loggerAlbumService")
public class LoggerAlbumService implements AlbumService {

  public Album readAlbum() {
    Album album = ArtefactBuilder.anAlbum();
    ConsoleApplication.logger.info("The album we read: " + album.getTitle());
    return album;
  }

}
