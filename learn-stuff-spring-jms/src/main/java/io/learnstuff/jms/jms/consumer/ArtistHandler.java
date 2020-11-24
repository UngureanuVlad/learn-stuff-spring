package io.learnstuff.jms.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import io.learnstuff.jms.domain.Artist;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@Component
public class ArtistHandler implements MessageListener {

  public final static Logger logger = LoggerFactory.getLogger(ArtistHandler.class);

  @JmsListener(destination = "demo.topic")
  public void onMessage(Message message) {
    logger.info("Consumed an artist message!");
    try {
      ObjectMessage objectMessage = (ObjectMessage) message;
      Artist artist = (Artist) objectMessage.getObject();
      logger.info("Read the artist: " + artist.getName() + "!");
    } catch (JMSException e) {
      logger.error("Artist handler encountered a problem: " + e.getMessage());
    }
  }
}
