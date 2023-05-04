package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    public static Connection connectToDB() {

        Connection connection = null;

        try (FileInputStream file = new FileInputStream("src/main/resources/config.properties")) {
            Properties properties = new Properties();
            properties.load(file);

            connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("USERNAME"), properties.getProperty("PASSWORD"));

        } catch (SQLException e) {
            System.out.println("Connection Failed : " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
