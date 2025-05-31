package io.learnstuff.mvc.controller;

import io.learnstuff.mvc.builders.ArtefactBuilder;
import io.learnstuff.mvc.domain.Artist;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ArtistController {

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/artist", method = RequestMethod.GET)
    @ResponseBody
    protected ModelAndView getArtist(Map model) throws Exception {

        Artist artist = (Artist) model.get("artist");
        // if it's a GET for an empty form
        if (artist == null || artist.getId() == null) {
            model.put("artist", new Artist());
        }

        return new ModelAndView("artist", model);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView createArtist(@ModelAttribute("artist") Artist artist,
                                     BindingResult result, Map model) {

        System.out.println(artist.getName());

        model.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });

        Artist parsedArtist = (Artist) model.get("artist");
        System.out.println(parsedArtist.getName());

        // validation result
        if (result.hasErrors()) {
            return new ModelAndView("artist", model);
        }

        // save or update based on the passed id value
        // this is part of the business logic

        // Literally do nothing, except re-initialisation
        return new ModelAndView("redirect:/list_artists", model);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/artist/raw", method = RequestMethod.POST)
    public ModelAndView createArtist(HttpServletRequest request) {
        try {
            System.out.println(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/list_artists", new HashMap());
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @RequestMapping(value = "/update_artist/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView update(@PathVariable("id") Long id) {
        // should actually search for artist first
        Map model = new HashMap();
        for (Artist artist : ArtefactBuilder.multipleArtistsWithId()) {
            if (artist.getId().toString().equals(id.toString())) {
                model.put("artist", artist);
            }
        }
        return new ModelAndView("artist", model);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/list_artists", method = RequestMethod.GET)
    protected @ResponseBody ModelAndView getArtists() throws Exception {
        Map model = new HashMap();
        model.put("artists", ArtefactBuilder.multipleArtistsWithId());
        return new ModelAndView("list_artists", model);
    }

}
