package io.learnstuff.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import io.learnstuff.rest.builders.ArtefactBuilder;
import io.learnstuff.rest.domain.Artist;
import io.learnstuff.rest.dto.ServiceResponse;

@RestController
public class ArtistController {

  public final static Logger logger = LoggerFactory.getLogger(ArtistController.class);

  @GetMapping(value = "/artist/{id}", produces = "application/json")
  protected Artist getArtist(@PathVariable Long id) throws Exception {
    logger.info("Called getArtist(" + id + ") service!");
    return ArtefactBuilder.anArtistWithId();
  }

  @PostMapping(value = "/artist", consumes = "application/json", produces = "application/json")
  public ServiceResponse createArtist(@RequestBody Artist artist) {
    logger.info("Called createArtist() service!");
    return new ServiceResponse();
  }

  @PutMapping(value = "/artist", consumes = "application/json", produces = "application/json")
  public ServiceResponse updateArtist(@RequestBody Artist artist) {
    logger.info("Called createArtist() service!");
    return new ServiceResponse();
  }

  @DeleteMapping(value = "/artist/{id}")
  public ServiceResponse deleteArtist(@RequestHeader("token") String token, @PathVariable Long id) {
    logger.info("Called deleteArtist(" + id + ") service with token: " + token + " !");
    return new ServiceResponse();
  }
}
