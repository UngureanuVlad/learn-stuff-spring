package io.learnstuff.jpa.db.repository;

import io.learnstuff.jpa.db.repository.contract.ArtistDataStore;
import io.learnstuff.jpa.db.repository.utils.ArtistRowMapper;
import io.learnstuff.jpa.domain.Artist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vlad Ungureanu
 */
@Repository("dbArtistDAO")
@EnableTransactionManagement
@Slf4j
public class DBArtistDAO implements ArtistDataStore {

    private SimpleJdbcInsert insertArtist;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        insertArtist = new SimpleJdbcInsert(dataSource).withTableName("sbs_artists")
                .usingGeneratedKeyColumns("id");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional
    public void storeArtist(Artist artist) {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", artist.getName());
        try {
            insertArtist.execute(parameters);
            log.info("Called simple JDBC inserter!");
        } catch (DataAccessException dae) {
            log.error("A database error occured: " + dae.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Artist> readArtist() {
        StringBuilder selectStatement = new StringBuilder();
        selectStatement.append("SELECT * FROM ").append("sbs_artists");

        List<Artist> artists = null;
        try {
            artists =
                    jdbcTemplate.query(selectStatement.toString(), new Object[]{}, new ArtistRowMapper());
            log.error("Read list of artists: {}", artists.size());
        } catch (DataAccessException dae) {
            log.error("A database error occured: " + dae.getMessage());
        }

        return artists;
    }

}
