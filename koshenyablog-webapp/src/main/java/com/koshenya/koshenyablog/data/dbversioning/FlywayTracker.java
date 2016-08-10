package com.koshenya.koshenyablog.data.dbversioning;

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

    private final static String TRACK_SCHEMA = "track_schema";
    private final static String CREATE_SCHEMA_SQL = "CREATE SCHEMA root;";

    private DataSource dataSource;

    public FlywayTracker(DataSource dataSource) {

        this.dataSource = dataSource;

        String trackSchema = System.getProperty(TRACK_SCHEMA);
        if ("true".equals(trackSchema)) {
            try {
                init();
                migrate();
            } catch (Exception e) {
                System.err.println("Failed to load resource: " + e.getStackTrace().toString());
            }
        }

    }

    private void init() {
        try(Connection connection = dataSource.getConnection()) {
            // Execute schema create script
            Statement statement = connection.createStatement();
            statement.execute(CREATE_SCHEMA_SQL);
        } catch (SQLException e) {
            // nothing to do, schema exists
        }
    }

    private void migrate() throws IOException {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setLocations("classpath:db");
        flyway.migrate();
    }
}
