package io.radiantdinosaurs.pokedb.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Handles creating the tables in the database
 * @author radiantdinosaurs
 */
public class CreateTables {

    /**
     * Creates a table in the database
     */
    public void createTablesInDatabase() {
        try {
            Connection conn = ConnectionManager.openConnection();
            Statement stmt = conn.createStatement();
            String tableCreationStatement = "CREATE TABLE IF NOT EXISTS " + Contract.DB_NAME + "." +
                    Contract.PokemonTable.TABLE_NAME + " ( " +
                    Contract.PokemonTable.ID + " INT PRIMARY KEY, " +
                    Contract.PokemonTable.NAME + " VARCHAR(255), " +
                    Contract.PokemonTable.TYPES + " VARCHAR(255), " +
                    Contract.PokemonTable.DEFENSE + " INT, " +
                    Contract.PokemonTable.ATTACK + " INT, " +
                    Contract.PokemonTable.HP + " INT, " +
                    Contract.PokemonTable.SPECIAL_DEFENSE + " INT, " +
                    Contract.PokemonTable.SPECIAL_ATTACK + " INT, " +
                    Contract.PokemonTable.SPEED + " INT)";
            stmt.executeUpdate(tableCreationStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

