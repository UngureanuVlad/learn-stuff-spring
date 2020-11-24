package io.learnstuff.security.main.config.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

  private String secretKey = "SteVmt6uqeCJlcffgKFf9gYD.Xo54WfH.dJ3Fq6$2a$10$WdkNALRQs5IRIZSteVmt6uqeCJlcffgKFf9gYD.Xo54WfH.dJ3Fq6";

  private long validityInMs = 3600000;

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }

  public long getValidityInMs() {
    return validityInMs;
  }

  public void setValidityInMs(long validityInMs) {
    this.validityInMs = validityInMs;
  }

}
