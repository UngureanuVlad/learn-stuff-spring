package io.learnstuff.ioc.services.impl;

import org.springframework.stereotype.Service;
import io.learnstuff.ioc.builders.ArtefactBuilder;
import io.learnstuff.ioc.domain.Album;
import io.learnstuff.ioc.services.contracts.AlbumService;


@Service("consoleAlbumService")
public class ConsoleAlbumService implements AlbumService {

  public Album readAlbum() {
    Album album = ArtefactBuilder.anAlbum();
    System.out.println("The album we read: " + album.getTitle());
    return album;
  }

}
