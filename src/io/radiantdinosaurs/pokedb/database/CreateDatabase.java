package io.radiantdinosaurs.pokedb.database;

import java.sql.*;

/**
 * Handles creating the database
 * @author radiantdinosaurs
 */
public class CreateDatabase {

    /**
     * Creates the database, pokedb, if it does not exist
     */
    public void createDatabase() {
        try {
            Connection conn = ConnectionManager.openConnection();
            Statement stmt = conn.createStatement();
            boolean databaseExists = CheckIfDatabaseExists.checkIfDatabaseExists();
            if(!databaseExists) {
                String databaseCreationStatement = "CREATE DATABASE IF NOT EXISTS " + Contract.DB_NAME;
                stmt.executeUpdate(databaseCreationStatement);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}