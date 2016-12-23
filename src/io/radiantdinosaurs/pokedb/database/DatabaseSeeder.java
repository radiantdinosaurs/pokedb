package io.radiantdinosaurs.pokedb.database;

import io.radiantdinosaurs.pokedb.models.Pokemon;
import org.json.simple.JSONObject;

import java.sql.*;

/**
 * Created by Bethany Corder on 12/22/2016.
 */
public class DatabaseSeeder {

    public static final String filePath = "C:\\Users\\Bethany Corder\\Google Drive\\Coding Projects\\IntelliJ IDEA Projects\\PokeDB\\src\\io\\radiantdinosaurs\\pokedb\\assets\\pokemon.json";
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement ps = null;
    CreateDatabaseAndTables cpt = new CreateDatabaseAndTables();

    public void checkIfTablesAreFilled() {
        try(Connection conn = cpt.openConnection()) {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name from pokemon");
            if(rs.next()) {
            }
            else {
                System.out.println("Populating the tables...");
                insertPokemonIntoDatabase();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertPokemonIntoDatabase() {
        Pokemon pokemon;
        try(Connection conn = cpt.openConnection()) {
            Object obj = ParseJSON.parseJson();
            JSONObject jsonObject = (JSONObject) obj;
            for(Object key : jsonObject.keySet()) {
                pokemon = ReadFromFileJSON.createPokemonObjectsFromJsonFile(key, jsonObject);
                String sql = "INSERT INTO pokemon (name,types,defense,attack,hp,special_defense,special_attack," +
                        "speed) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
                ps = conn.prepareStatement(sql);
                ps.setString(1, pokemon.getName());
                ps.setString(2, pokemon.typesToString());
                ps.setInt(3, pokemon.getDefense());
                ps.setInt(4, pokemon.getAttack());
                ps.setInt(5, pokemon.getHp());
                ps.setInt(6, pokemon.getSpecialDefense());
                ps.setInt(7, pokemon.getSpecialAttack());
                ps.setInt(8, pokemon.getSpeed());
                ps.executeUpdate();
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

}