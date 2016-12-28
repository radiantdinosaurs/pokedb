package io.radiantdinosaurs.pokedb.database;

import java.sql.*;

/**
 * TODO: while this class creates a database and its tables, it also creates a Connection instance.
 * In a lot of database helper classes, they follow a consistent pattern of creating the connection
 * on initialization and using the same connection for the duration of the instance.
 *
 * In your case, you create a new connection regardless.
 *
 * A common way of avoiding this would be to do null checks before instantiation.
 *
 * For example,
 *
 * if(conn == null) {
 *     conn = ...;
 * }
 *
 * return conn;
 *
 * Also, this class could be made more robust with a little extra work.
 * For example, adding functions dedicated to checking if a database exists would expose a valuable method and something
 * you can use in this class.
 * Furthermore, this class could be refactored to follow the single responsibility principle.
 * Using this approach will usually make a class more testable if implemented successfully
 *
 * - Andrew
 *
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

            // TODO: instead of holding the specific query in this method, it would be better practice
            // to keep it in its own class as a constant or within this class a constant.
            // This improves the visibility of it and reduces the possibility of mismatched values, i.e.
            // you use this same query somewhere else and forget to update the value here.
            ResultSet rs = stmt.executeQuery("SHOW DATABASES LIKE 'pokedb'");
            boolean doesDatabaseExist = rs.next();

            // TODO: this if statement could be simplified
            // if(databaseDoesNotExist)
            if (doesDatabaseExist) {
                return;
            } else {
                // TODO: it's bad practice to do more than what the method name suggests.
                // "checkIfDatabaseExists" implies it just checks whether or not the database exists
                // and potentially returns a boolean.
                // however, you're creating the database here, too.
                // if someone were to come into this code base and didn't look in this class,
                // they may call checkIfDatabaseExists without realizing it will try to create the database as well.
                //
                // TODO: consider renaming this method to "createDatabaseIfDoesNotExist" or making it return a boolean
                // and not call "createDatabase".
                // - Andrew

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

            // TODO: same comment about holding specific constants like DB name as their own variables.
            // - Andrew
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
            // TODO: consider refactoring this to use the values from your Contract class.
            // - Andrew
            String tableCreationStatement = "CREATE TABLE IF NOT EXISTS pokemon ( id INT PRIMARY KEY, " +
                    "name VARCHAR(255), types VARCHAR(255), defense INT, attack INT, hp INT, special_defense INT, " +
                    "special_attack INT, speed INT)";
            stmt.executeUpdate(tableCreationStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}