package io.radiantdinosaurs.pokedb.database;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Bethany Corder on 12/14/2016.
 */
public class JSONReadFromFile {

    public static final String filePath = "C:\\Users\\Bethany Corder\\Google Drive\\Coding Projects\\IntelliJ IDEA Projects\\PokeDB\\src\\io\\radiantdinosaurs\\pokedb\\assets\\pokemon.json";

    public void parseJsonObject() {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;
        printJsonObject(jsonObject);
    }

    public void printJsonObject(JSONObject jsonObj) {
        for(Object key : jsonObj.keySet()) {
            String keyPokemonNames = (String)key;
            Object keyPokemonValues = jsonObj.get(keyPokemonNames);
            System.out.println("key: "+ keyPokemonNames);
            System.out.println("value: " + keyPokemonValues);
        }
    }
}