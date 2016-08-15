package com.koshenya.koshenyablog.data.dbversioning;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sony on 7/31/2016.
 */
public class FlywayTracker {

    private final static Logger log = Logger.getLogger(FlywayTracker.class);

    private final static String CREATE_SCHEMA_SQL = "CREATE SCHEMA ROOT";

    private DataSource dataSource;

    private boolean trackSchema;

    public FlywayTracker(DataSource dataSource, boolean trackSchema) {

        this.dataSource = dataSource;
        this.trackSchema = trackSchema;

        if (trackSchema) {
            try {
                init();
                migrate();
            } catch (Exception e) {
                System.err.println("Failed to load resource: " + e);
            }
        }

    }

    private void init() {
        try(Connection connection = dataSource.getConnection()) {
            // Execute schema create script
            Statement statement = connection.createStatement();
            statement.execute(CREATE_SCHEMA_SQL);

            log.info("Successfully created schema ROOT");

        } catch (SQLException e) {
            // nothing to do, schema exists
            log.info("Schema ROOT already exists!\n" );
            e.printStackTrace();
        }
    }

    private void migrate() throws IOException {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("classpath:db");
        flyway.migrate();
    }

    public void setTrackSchema(boolean trackSchema) {
        this.trackSchema = trackSchema;
    }
}
