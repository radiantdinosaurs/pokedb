package io.radiantdinosaurs.pokedb.database;

import java.sql.*;
import java.util.Vector;

/**
 * Reads in data from the database
 * @author radiantdinosaurs
 */
public class DatabaseReader {
    
    private Connection conn;

    /**
     * Generates column names from the database for the JTable
     * @return names of the columns
     */
    public Vector<Object> columnsOfPokemonForTable() {
        ResultSet rs;
        Vector<Object> columnNames = new Vector<>();
        try {
            conn = ConnectionManager.openConnection();
            String sql = "SELECT " + Contract.PokemonTable.NAME + ", " + Contract.PokemonTable.TYPES + ", " +
                    Contract.PokemonTable.DEFENSE + ", " + Contract.PokemonTable.ATTACK + ", " +
                    Contract.PokemonTable.HP + ", " +
                    Contract.PokemonTable.SPECIAL_DEFENSE + ", " +
                    Contract.PokemonTable.SPECIAL_ATTACK + ", " +
                    Contract.PokemonTable.SPEED + " " +
                    "FROM " + Contract.DB_NAME + "." + Contract.PokemonTable.TABLE_NAME + ";";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();

            int columnCount = md.getColumnCount();
            //Adding the column names to the Vector and making them look nice
            for(int i = 1; i <= columnCount; i++) {
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
        try {
            conn = ConnectionManager.openConnection();
            String query = "SELECT " + Contract.PokemonTable.NAME + ", " + Contract.PokemonTable.TYPES + ", " +
                    Contract.PokemonTable.DEFENSE + ", " + Contract.PokemonTable.ATTACK + ", " +
                    Contract.PokemonTable.HP + ", " +
                    Contract.PokemonTable.SPECIAL_DEFENSE + ", " +
                    Contract.PokemonTable.SPECIAL_ATTACK + ", " +
                    Contract.PokemonTable.SPEED + " " +
                    "FROM " + Contract.DB_NAME + "." + Contract.PokemonTable.TABLE_NAME + ";";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            pokemonData = resultSetToVector(rs, columns);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return pokemonData;
    }

    /**
     * Creates a vector of objects from a result set
     * @param rs result set of pokemon from the table
     * @param columns number of columns
     * @return
     */
    public Vector<Object> resultSetToVector(ResultSet rs, int columns) {
        Vector<Object> pokemonData = new Vector<>();
        try {
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
