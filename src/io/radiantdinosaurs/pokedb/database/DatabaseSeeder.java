package io.radiantdinosaurs.pokedb.database;

import io.radiantdinosaurs.pokedb.models.Pokemon;
import org.json.simple.JSONObject;
import java.sql.*;

/**
 * Populates the database with Pokemon
 * @author radiantdinosaurs
 */
public class DatabaseSeeder {

    private PreparedStatement ps = null;
    // TODO: consider applying a modifier to this class
    // TODO: same comments about this class as in DatabaseReader
    CreateDatabaseAndTables cpt = new CreateDatabaseAndTables();

    /**
     * Seeds the database with Pokemon
     */
    public void insertPokemonIntoDatabase() {
        Pokemon pokemon;
        try(Connection conn = cpt.openConnection()) {
            //Getting an object from the JSON file
            Object parsedJsonFile = ReadFromFileJSON.parseJson();
            //Casting the object to a JSON object
            JSONObject jsonObject = (JSONObject) parsedJsonFile;
            int id = 1;
            //Iterating through the JSON object and inserting the Pokemon's information into the database
            for(Object key : jsonObject.keySet()) {
                pokemon = ParseObjectJSON.createPokemonFromJson(key, jsonObject);
                //IGNORE will ignore the particular insert if the Pokemon already exists in the table
                //
                // TODO: use the constants from the Contract class
                // - Andrew
                String sql = "INSERT IGNORE INTO pokemon (id,name,types,defense,attack,hp,special_defense," +
                        "special_attack, speed) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?);";

                // TODO: consider breaking this logic out into its own method
                // - Andrew
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setString(2, pokemon.getName());
                ps.setString(3, pokemon.typesToString());
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