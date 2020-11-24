package io.learnstuff.jpa.db.repository.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import io.learnstuff.jpa.domain.Artist;

@SuppressWarnings("rawtypes")
public class ArtistRowMapper implements RowMapper {

  @Override
  public Artist mapRow(ResultSet rs, int line) throws SQLException {
    ArtistResultSetExtractor extractor = new ArtistResultSetExtractor();
    return extractor.extractData(rs);
  }
}
