package io.learnstuff.jms.jms.consumer;


import io.learnstuff.jms.domain.Artist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Vlad Ungureanu
 */
@Component
public class ArtistHandler {

    public final static Logger logger = LoggerFactory.getLogger(ArtistHandler.class);

    @RabbitListener(queues = "artist_queue")
    public void onMessage(Artist artist) {
        logger.info("Consumed an artist message!");
        try {
            System.out.println(artist);
            logger.info("Read the artist: " + artist.getName() + "!");
        } catch (Exception e) {
            logger.error("Artist handler encountered a problem: " + e.getMessage());
        }
    }
}
