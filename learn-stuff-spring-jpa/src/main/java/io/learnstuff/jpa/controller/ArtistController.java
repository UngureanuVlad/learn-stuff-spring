package io.learnstuff.jpa.controller;

import io.learnstuff.jpa.db.repository.contract.ArtistDataStore;
import io.learnstuff.jpa.domain.Artist;
import io.learnstuff.jpa.dto.ServiceResponse;
import io.learnstuff.repository.ArtistDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArtistController {

    private final ArtistDAO artistDAO;
    private final ArtistDataStore artistDataStore;

    @GetMapping(value = "/artist/{id}", produces = "application/json")
    public Artist getArtist(@PathVariable Long id) throws Exception {
        log.info("Called getArtist({}) service!", id);
        return artistDAO.findById(id);
    }

    @PostMapping(value = "/artist", consumes = "application/json", produces = "application/json")
    public Artist createArtist(@RequestBody Artist artist) {
        log.info("Called createArtist() JPA service!");
        artistDAO.save(artist);
        return artist;
    }

    @PostMapping(value = "/artist_db", consumes = "application/json", produces = "application/json")
    public ServiceResponse createArtistDB(@RequestBody Artist artist) {
        log.info("Called createArtist() JDBC service!");
        artistDataStore.storeArtist(artist);
        return new ServiceResponse();
    }

    @PutMapping(value = "/artist/{id}", consumes = "application/json", produces = "application/json")
    public ServiceResponse updateArtist(@RequestBody Artist artist, @PathVariable Long id) {
        log.info("Called updateArtist() service!");
        artist.setId(id);
        artistDAO.update(artist);
        return new ServiceResponse();
    }

    @DeleteMapping(value = "/artist/{id}")
    public ServiceResponse deleteArtist(@PathVariable Long id) {
        log.info("Called deleteArtist({}) service!", id);
        artistDAO.delete(id);
        return new ServiceResponse();
    }
}
