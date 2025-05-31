package io.learnstuff.jms.controller;

import io.learnstuff.jms.builders.ArtefactBuilder;
import io.learnstuff.jms.domain.Artist;
import io.learnstuff.jms.dto.ServiceResponse;
import io.learnstuff.jms.jms.producer.ArtistProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ArtistController {

    private final ArtistProducer artistProducer;

    @PostMapping(value = "/artist", consumes = "application/json", produces = "application/json")
    public ServiceResponse createArtist(@RequestBody Artist artist) {
        log.info("Called createArtist() service!");
        artistProducer.send(artist);
        return new ServiceResponse();
    }

    @GetMapping(value = "/artist", produces = "application/json")
    public ServiceResponse mockCreateArtist() {
        log.info("Called mockCreateArtist() service!");
        Artist artist = ArtefactBuilder.anArtist();
        artistProducer.send(artist);
        return new ServiceResponse();
    }
}
