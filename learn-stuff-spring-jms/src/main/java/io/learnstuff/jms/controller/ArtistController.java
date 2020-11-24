package io.learnstuff.jms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.learnstuff.jms.domain.Artist;
import io.learnstuff.jms.dto.ServiceResponse;
import io.learnstuff.jms.jms.producer.ArtistProducer;

@RestController
public class ArtistController {

  @Autowired
  private ArtistProducer artistProducer;

  public final static Logger logger = LoggerFactory.getLogger(ArtistController.class);

  @PostMapping(value = "/artist", consumes = "application/json", produces = "application/json")
  public ServiceResponse createArtist(@RequestBody Artist artist) {
    logger.info("Called createArtist() service!");
    artistProducer.send(artist);
    return new ServiceResponse();
  }
}
