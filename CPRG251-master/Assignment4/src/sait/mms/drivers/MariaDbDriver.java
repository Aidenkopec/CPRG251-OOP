package sait.mms.drivers;

import sait.mms.contracts.DatabaseDriver;

import java.sql.*;

/**
 * Driver class of the database connection and operations
 * @author Allyssa Preece
 * @author Anusone Soula
 * @author Aiden Kopec
 *
 * @version April 13, 2022
 */
public class MariaDbDriver implements DatabaseDriver{
    private static final String SERVER = "localhost";
    private static final int PORT = 3306;
    private static final String DATABASE = "cprg251";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";
    
    Connection connection = null;

    /**
     * Creates a new connection to the database
     * @throws SQLException if the connection cannot be made
     */
    @Override
    public void connect() throws SQLException {
        String dsn = this.getDsn();
        connection = DriverManager.getConnection(dsn);
    }

    /**
     * Creates the data source name with the database information
     * @return the data source name
     */
    private String getDsn() {
        return String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", SERVER, PORT, DATABASE, USERNAME, PASSWORD);
    }

    /**
     * Executes a select query in the database
     * @param query Query to send to database.
     * @return the results of the query
     * @throws SQLException if the query cannot be executed
     */
    @Override
    public ResultSet get(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    /**
     * Executes an insert or delete query to update the database
     * @param query Query to send to database.
     * @return the number of rows updated
     * @throws SQLException if the query cannot be executed
     */
    @Override
    public int update(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeUpdate(query);
    }

    /**
     * Closes the connection to the database
     * @throws SQLException if the connection cannot be closed
     */
    @Override
    public void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
