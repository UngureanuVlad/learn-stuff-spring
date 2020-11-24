package io.learnstuff.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.learnstuff.rest.builders.ArtefactBuilder;
import io.learnstuff.rest.domain.Artist;
import io.learnstuff.rest.dto.ServiceResponse;

@RestController
public class ArtistController {

  public final static Logger logger = LoggerFactory.getLogger(ArtistController.class);

  @RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
  protected Artist getArtist(@PathVariable Long id) throws Exception {
    logger.info("Called get Artist (" + id + ") service!");
    return ArtefactBuilder.anArtistWithId();
  }

  @RequestMapping(value = "/artist", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ServiceResponse createArtist(Artist artist) {
    logger.info("Called create Artist service!");
    return new ServiceResponse();
  }

  @RequestMapping(value = "/artist", method = RequestMethod.PUT, consumes = "application/json",
      produces = "application/json")
  public ServiceResponse updateArtist(Artist artist) {
    logger.info("Called update Artist service!");
    return new ServiceResponse();
  }

  @RequestMapping(value = "/artist/{id}", method = RequestMethod.DELETE)
  public ServiceResponse deleteArtist(@RequestHeader("token") String token, @PathVariable Long id) {
    logger.info("Called delete Artist (" + id + ") service with token: " + token + " !");
    return new ServiceResponse();
  }
}
