package io.learnstuff.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.learnstuff.security.domain.Artist;

@RestController
public class ArtistController {

  public final static Logger logger = LoggerFactory.getLogger(ArtistController.class);

  @PostMapping(value = "/artist", consumes = "application/json", produces = "application/json")
  public Artist createArtist(@RequestBody Artist artist) {
    logger.info("Called createArtist() service!");
    return artist;
  }
}
