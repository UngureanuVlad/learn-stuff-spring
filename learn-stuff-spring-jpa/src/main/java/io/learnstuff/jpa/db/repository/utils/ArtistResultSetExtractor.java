package io.learnstuff.jpa.db.repository.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.ResultSetExtractor;
import io.learnstuff.jpa.domain.Artist;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
public class ArtistResultSetExtractor implements ResultSetExtractor<Artist> {

  @Override
  public Artist extractData(ResultSet rs) throws SQLException {
    Artist cashDrawer = new Artist();
    cashDrawer.setName(rs.getString("name"));
    return cashDrawer;
  }

}
