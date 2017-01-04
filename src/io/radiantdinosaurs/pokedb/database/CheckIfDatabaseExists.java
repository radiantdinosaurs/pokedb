package io.radiantdinosaurs.pokedb.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Checks if database exists
 * @author radiantdinosaurs
 */
class CheckIfDatabaseExists {

    /**
     * Makes a query to search the local host for a database name
     */
    static boolean checkIfDatabaseExists() {
        boolean databaseExists = true;
        try {
            Connection conn = ConnectionManager.openConnection();
            Statement stmt = conn.createStatement();
            String query = "SHOW DATABASES LIKE '" + Contract.DB_NAME + "'";
            ResultSet rs = stmt.executeQuery(query);
            databaseExists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return databaseExists;
    }

}
