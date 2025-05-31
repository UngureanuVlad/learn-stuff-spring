package io.learnstuff.security.controller;

import io.learnstuff.security.domain.DomainArtist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/artist")
public class ArtistController {

    @PostMapping
    public DomainArtist createArtist(@RequestBody DomainArtist domainArtist) {
        log.info("Called createArtist() service!");
        return domainArtist;
    }

    @GetMapping
    public List<DomainArtist> getArtists() {
        log.info("Called getArtists() service!");
        DomainArtist domainArtist = new DomainArtist();
        domainArtist.setName("Artist");
        domainArtist.setId(1L);
        return List.of(domainArtist);
    }
}
