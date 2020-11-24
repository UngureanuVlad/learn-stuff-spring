package io.learnstuff.mvc.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesApplicationConfiguration implements WebMvcConfigurer {
  
  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
      "classpath:/META-INF/resources/", "classpath:/resources/",
      "classpath:/static/", "classpath:/public/" };
  
  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    
    tilesConfigurer.setDefinitions(new String[] {"classpath:tiles-definitions.xml"});
    tilesConfigurer.setCheckRefresh(true);

    return tilesConfigurer;
  }

  @Bean
  public UrlBasedViewResolver tilesViewResolver() {
      UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
      tilesViewResolver.setViewClass(TilesView.class);
      return tilesViewResolver;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations(
        CLASSPATH_RESOURCE_LOCATIONS);
  }
}
