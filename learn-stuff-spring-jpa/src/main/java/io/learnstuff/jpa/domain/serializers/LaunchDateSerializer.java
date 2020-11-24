package io.learnstuff.jpa.domain.serializers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author Vlad Ungureanu
 */
public class LaunchDateSerializer extends JsonSerializer<Date> {

  @Override
  public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    String formattedDate = formatter.format(value);

    jgen.writeString(formattedDate);
  }
}
