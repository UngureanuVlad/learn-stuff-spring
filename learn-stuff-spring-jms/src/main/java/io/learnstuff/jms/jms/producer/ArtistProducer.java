package io.learnstuff.jms.jms.producer;

import io.learnstuff.jms.domain.Artist;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Vlad Ungureanu
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ArtistProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(final Artist artist) {
        log.info("Produced an artist message!");
        rabbitTemplate.convertAndSend("artist_queue", artist);
    }
}
