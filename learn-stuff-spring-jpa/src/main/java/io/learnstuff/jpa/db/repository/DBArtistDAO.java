package io.learnstuff.jpa.db.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import io.learnstuff.jpa.db.repository.contract.ArtistDataStore;
import io.learnstuff.jpa.db.repository.utils.ArtistRowMapper;
import io.learnstuff.jpa.domain.Artist;

/**
 * 
 * @author Vlad Ungureanu
 *
 */
@Repository("dbArtistDAO")
@EnableTransactionManagement
public class DBArtistDAO implements ArtistDataStore {

  public final static Logger logger = LoggerFactory.getLogger(DBArtistDAO.class);

  private SimpleJdbcInsert insertArtist;
  private JdbcTemplate jdbcTemplate;

  @Autowired
  public void setDataSource(DataSource dataSource) {
    insertArtist = new SimpleJdbcInsert(dataSource).withTableName("sbs_artists")
        .usingGeneratedKeyColumns("id");;
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Transactional
  public void storeArtist(Artist artist) {

    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("name", artist.getName());
    try {
      insertArtist.execute(parameters);
      logger.info("Called simple JDBC inserter!");
    } catch (DataAccessException dae) {
      logger.error("A database error occured: " + dae.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public List<Artist> readArtist() {
    StringBuilder selectStatement = new StringBuilder();
    selectStatement.append("SELECT * FROM ").append("sbs_artists");

    List<Artist> artists = null;
    try {
      artists =
          jdbcTemplate.query(selectStatement.toString(), new Object[] {}, new ArtistRowMapper());
      logger.error("Read list of artists: " + artists.size());
    } catch (DataAccessException dae) {
      logger.error("A database error occured: " + dae.getMessage());
    }

    return artists;
  }

}
