package io.radiantdinosaurs.pokedb.database;

import java.sql.*;
import java.util.Vector;

import static io.radiantdinosaurs.pokedb.database.Contract.PokemonTable.*;

/**
 * Reads in data from the database
 * @author radiantdinosaurs
 */
public class DatabaseReader {

    /**
     * TODO: this is where the refactoring mentioned in CreateDatabaseAndTables could come in handy.
     * The name only makes one believe that those two things are what the class does, but the class
     * also provides a connection instance.
     *
     * Therefore, a name like "PokeDbHelper" might be more sufficient. Helper classes typically provide
     * a bunch of helpful functions for a specific duty. In this case, providing universal database functions.
     *
     * For example,
     *
     * pokeDbHelper.openConnection();
     * pokeDbHelper.closeConnection();
     * pokeDbHelper.doesDatabaseExist();
     *
     * - Andrew
     */
    private CreateDatabaseAndTables cpt = new CreateDatabaseAndTables();

    /**
     * Generates column names from the database for the JTable
     * @return names of the columns
     */
    public Vector<Object> columnsOfPokemonForTable() {
        ResultSet rs;
        Vector<Object> columnNames = new Vector<>();
        try(Connection conn = cpt.openConnection()) {
            //
            // TODO: use the constants from the Contract class
            // - Andrew
            String sql = "SELECT name, types, defense, attack, hp, special_defense, special_attack, speed " +
                    "FROM pokemon;";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();

            // TODO: consider renaming to columnCount
            // columns makes me think of the actual column names
            // - Andrew
            int columns = md.getColumnCount();
            //Adding the column names to the Vector and making them look nice
            for(int i = 1; i <= columns; i++) {
                columnNames.addElement(md.getColumnName(i).toUpperCase().replace("_", " "));
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return columnNames;
    }

    /**
     * Gets Pokemon from the database to make rows of for the JTable
     * @return Pokemon information from database
     */
    public Vector<Object> dataOfPokemonForTable() {
        ResultSet rs;
        Vector<Object> pokemonData = new Vector<>();
        try(Connection conn = cpt.openConnection()) {
            //
            // TODO: consider using the constants in the Contract class
            // - Andrew
            String query = "SELECT name, types, defense, attack, hp, special_defense, special_attack, speed " +
                    "FROM pokemon;";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            // TODO: consider moving this logic out into its own method
            // it can take a ResultSet as a param and return a Vector of Pokemon objects
            // - Andrew
            while(rs.next()) {
                //Making sure that we'll have the right information in the right column
                Vector<Object> row = new Vector<>(columns);
                for(int i = 1; i <= columns; i++) {
                    //Adding Pokemon's information to the appropriate column
                    row.addElement(rs.getObject(i));
                }
                //Adding the complete Pokemon to the Vector
                pokemonData.addElement(row);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return pokemonData;
    }
}
