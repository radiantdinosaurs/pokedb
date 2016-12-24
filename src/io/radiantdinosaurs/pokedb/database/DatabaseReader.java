package io.radiantdinosaurs.pokedb.database;

import java.sql.*;
import java.util.Vector;

import static io.radiantdinosaurs.pokedb.database.Contract.PokemonTable.*;

/**
 * Reads in data from the database
 * @author radiantdinosaurs
 */
public class DatabaseReader {

    private CreateDatabaseAndTables cpt = new CreateDatabaseAndTables();

    /**
     * Generates column names from the database for the JTable
     * @return names of the columns
     */
    public Vector<Object> columnsOfPokemonForTable() {
        ResultSet rs;
        Vector<Object> columnNames = new Vector<>();
        try(Connection conn = cpt.openConnection()) {
            String sql = "SELECT name, types, defense, attack, hp, special_defense, special_attack, speed " +
                    "FROM pokemon;";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
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
            String query = "SELECT name, types, defense, attack, hp, special_defense, special_attack, speed " +
                    "FROM pokemon;";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
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
