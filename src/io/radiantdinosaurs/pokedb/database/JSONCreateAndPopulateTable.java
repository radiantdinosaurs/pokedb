package io.radiantdinosaurs.pokedb.database;

import java.sql.*;
/**
 * Created by Bethany Corder on 12/16/2016.
 */
public class JSONCreateAndPopulateTable {

    private Connection conn = null;
    private Statement stmt = null;

    public Connection openInitialConnection() {
        try {
            conn = DriverManager.getConnection(Contract.URL, Contract.USER, Contract.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Connection openConnection() {
        try {
            conn = DriverManager.getConnection(Contract.DB_URL, Contract.USER, Contract.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void createDatabase() {
        try(Connection conn = openInitialConnection()) {
            stmt = conn.createStatement();
            System.out.println("Creating database...");
            String databaseCreationStatement = "CREATE DATABASE IF NOT EXISTS pokedb";
            stmt.executeUpdate(databaseCreationStatement);
            System.out.println("Database created successfully!");
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public void checkIfDatabaseExists() {
        try (Connection conn = openInitialConnection()) {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SHOW DATABASES LIKE 'pokedb'");
            boolean doesDatabaseExist = rs.next();
            if (doesDatabaseExist) {
                System.out.println("Found the database!");
            } else {
                createDatabase();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTablesInDatabase() {
        try(Connection conn = openConnection()) {
            System.out.println("Creating tables...");
            stmt = conn.createStatement();
            String tableCreationStatement = "CREATE TABLE pokemon ( id INT PRIMARY KEY, types VARCHAR(255), defense INT, attack INT, hp INT, special_defense INT, special_attack INT, speed INT)";
            stmt.executeUpdate(tableCreationStatement);
            System.out.println("Created table in the database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkIfTablesExistInDatabase() {
        try(Connection conn = openConnection()) {
            DatabaseMetaData md = conn.getMetaData();
            ResultSet rs = md.getTables(null, null, "POKEMON", null);
            if(rs.next()) {
                System.out.println("Found the tables!");
            }
            else {
                createTablesInDatabase();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
