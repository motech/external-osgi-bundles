package org.motechproject.osgi.postgresql;

import org.motechproject.testing.osgi.BaseOsgiIT;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PostgresOsgiBundleIT extends BaseOsgiIT {

    public void testBundle() throws IOException {
        assertNotNull(bundleContext.getBundles());

        Properties postgresProperties = new Properties();
        postgresProperties.load(this.getClass().getClassLoader().getResourceAsStream("postgres.properties"));
        try {
            Class.forName(postgresProperties.getProperty("jdbc.driverClassName"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            fail("Driver not found");
        }
        try {
            DriverManager.getConnection(postgresProperties.getProperty("jdbc.url"), postgresProperties.getProperty("jdbc.username"), postgresProperties.getProperty("jdbc.password"));
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Not able to connect to DB");
        }
    }

    @Override
    protected List<String> getImports() {
        return Arrays.asList("org.postgresql");
    }
}
