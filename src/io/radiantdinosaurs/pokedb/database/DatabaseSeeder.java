package io.radiantdinosaurs.pokedb.database;

import io.radiantdinosaurs.pokedb.models.Pokemon;
import io.radiantdinosaurs.pokedb.models.Type;
import org.json.simple.JSONObject;
import java.sql.*;

/**
 * Populates the database with Pokemon
 * @author radiantdinosaurs
 */
public class DatabaseSeeder {

    // TODO: consider applying a modifier to this class

    /**
     * Seeds the database with Pokemon
     */
    public void insertPokemonIntoDatabase() {
        Pokemon pokemon;
        Type types;
        try {
            Connection conn = ConnectionManager.openConnection();
            //Getting an object from the JSON file
            Object parsedJsonFile = ReadFromFileJSON.parseJson();
            //Casting the object to a JSON object
            JSONObject jsonObject = (JSONObject) parsedJsonFile;
            int id = 1;
            //Iterating through the JSON object and inserting the Pokemon's information into the database
            for(Object key : jsonObject.keySet()) {
                pokemon = ParseJSONObjectToPokemonObject.createPokemonFromJson(key, jsonObject);
                //IGNORE will ignore the particular insert if the Pokemon already exists in the table
                String sql = "INSERT IGNORE INTO " +
                        Contract.DB_NAME + "." +
                        Contract.PokemonTable.TABLE_NAME + " (" +
                        Contract.PokemonTable.ID + ", " +
                        Contract.PokemonTable.NAME + ", " +
                        Contract.PokemonTable.TYPES + " , " +
                        Contract.PokemonTable.DEFENSE + ", " +
                        Contract.PokemonTable.ATTACK + " , " +
                        Contract.PokemonTable.HP + " " + ", " +
                        Contract.PokemonTable.SPECIAL_DEFENSE + "," +
                        Contract.PokemonTable.SPECIAL_ATTACK + " , " +
                        Contract.PokemonTable.SPEED + ") VALUES (?,?, ?, ?, ?, ?, ?, ?, ?);";

                // TODO: consider breaking this logic out into its own method
                // - Andrew
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, pokemon.getName());
                ps.setString(3, pokemon.convertTypesToString());
                ps.setInt(4, pokemon.getDefense());
                ps.setInt(5, pokemon.getAttack());
                ps.setInt(6, pokemon.getHp());
                ps.setInt(7, pokemon.getSpecialDefense());
                ps.setInt(8, pokemon.getSpecialAttack());
                ps.setInt(9, pokemon.getSpeed());
                ps.executeUpdate();
                id++;
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}