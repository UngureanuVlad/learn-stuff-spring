package io.learnstuff.jms.builders;

import io.learnstuff.jms.domain.Artist;
import io.learnstuff.jms.domain.Gender;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vlad Ungureanu
 */
public class ArtefactBuilder {

    public static Artist anArtist() {
        Artist artist = new Artist();
        artist.setName("Metallica");
        artist.setOrigin("California, USA");
        artist.setLaunchDate(new Date());
        artist.setGenders(genders());
        return artist;
    }

    public static Gender aGender() {
        Gender gender = new Gender();
        gender.setName("Rock");
        return gender;
    }

    public static Set<Gender> genders() {
        Set<Gender> genders = new HashSet<Gender>();
        genders.add(aGender());
        return genders;
    }
}
