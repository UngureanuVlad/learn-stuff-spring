package io.learnstuff.jms.jms.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import io.learnstuff.jms.domain.Artist;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@Component
public class ArtistProducer {
  public final static Logger logger = LoggerFactory.getLogger(ArtistProducer.class);

  private final JmsTemplate jmsTemplate;

  @Autowired
  public ArtistProducer(final JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  public void send(final Artist artist) {
    logger.info("Produced an artist message!");
    jmsTemplate.convertAndSend("demo.topic", artist);
  }
}
