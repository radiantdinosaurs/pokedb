package io.radiantdinosaurs.pokedb.database;

import java.sql.*;

/**
 * Handles creating the database and tables
 * @author radiantdinosaurs
 */
public class CreateDatabaseAndTables {

    private Connection conn = null;
    private Statement stmt = null;

    /**
     * Opens a connection to localhost
     * @return connection to localhost
     */
    private Connection openInitialConnection() {
        try {
            conn = DriverManager.getConnection(Contract.URL, Contract.USER, Contract.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Opens a connection to the database, pokedb
     * @return connection to pokedb
     */
    Connection openConnection() {
        try {
            conn = DriverManager.getConnection(Contract.DB_URL, Contract.USER, Contract.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Checks if the database exists
     */
    public void checkIfDatabaseExists() {
        try (Connection conn = openInitialConnection()) {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW DATABASES LIKE 'pokedb'");
            boolean doesDatabaseExist = rs.next();
            if (doesDatabaseExist) {
                return;
            } else {
                //Calls to create a database if the database is not found
                createDatabase();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the database, pokedb, if it does not exist
     */
    private void createDatabase() {
        try(Connection conn = openInitialConnection()) {
            stmt = conn.createStatement();
            String databaseCreationStatement = "CREATE DATABASE IF NOT EXISTS pokedb";
            stmt.executeUpdate(databaseCreationStatement);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * Creates a table in the database
     */
    public void createTablesInDatabase() {
        try(Connection conn = openConnection()) {
            stmt = conn.createStatement();
            String tableCreationStatement = "CREATE TABLE IF NOT EXISTS pokemon ( id INT PRIMARY KEY, " +
                    "name VARCHAR(255), types VARCHAR(255), defense INT, attack INT, hp INT, special_defense INT, " +
                    "special_attack INT, speed INT)";
            stmt.executeUpdate(tableCreationStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}