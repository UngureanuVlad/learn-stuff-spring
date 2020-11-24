package io.learnstuff.ioc.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import io.learnstuff.ioc.builders.ArtefactBuilder;
import io.learnstuff.ioc.services.contracts.ArtistService;


public class ConsoleApplication {

  public final static Logger logger = LoggerFactory.getLogger(ConsoleApplication.class);

  /**
   * Main method.
   */
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    logger.info("Initializing Spring context.");

    ApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("/application-context.xml");

    logger.info("Spring context initialized.");

    ArtistService artistService = (ArtistService) applicationContext.getBean("artistService");
    artistService.showArtist(ArtefactBuilder.anArtist());

    logger.info("Spring context end.");
  }

}
