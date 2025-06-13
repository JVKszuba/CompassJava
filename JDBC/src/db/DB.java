package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection == null) {

            try {

                Properties prop = loadProperties();
                String url = prop.getProperty("dburl");

                connection = DriverManager.getConnection(url, prop);

            } catch (SQLException e) {throw new DbException(e.getMessage());}
        }

        return connection;
    }

    public static void closeConnection() {

        if (connection != null) {

            try {connection.close();}
            catch (SQLException e) {throw new DbException(e.getMessage());}
        }
    }

    public static void closeStatement(Statement st) {

        if (st != null) {

            try {st.close();}
            catch (SQLException e) {throw new DbException(e.getMessage());}
        }
    }

    public static void closeResultSet(ResultSet rs) {

        if (rs != null) {

            try {rs.close();}
            catch (SQLException e) {throw new DbException(e.getMessage());}
        }
    }

    private static Properties loadProperties() {

        try (FileInputStream fis = new FileInputStream("db.properties")) {

            Properties prop = new Properties();

            prop.load(fis);

            return prop;

        } catch (IOException e) {throw new DbException(e.getMessage());}
    }


}
