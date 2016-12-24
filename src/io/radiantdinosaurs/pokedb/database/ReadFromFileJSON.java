package io.radiantdinosaurs.pokedb.database;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Parses JSON files into JSON objects
 * @author radiantdinosaurs
 */
class ReadFromFileJSON {

    private static final String jsonFilePath = "C:\\Users\\Bethany Corder\\Google Drive\\Coding Projects\\" +
            "IntelliJ IDEA Projects\\PokeDB\\src\\io\\radiantdinosaurs\\pokedb\\assets\\pokemon.json";
    /**
     * Parses the Pokemon JSON file into an object
     * @return a JSON object
     */
    static Object parseJson() {
        JSONParser parser = new JSONParser();
        Object parsedJsonFile = null;
        try {
            parsedJsonFile = parser.parse(new FileReader(jsonFilePath));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return parsedJsonFile;
    }
}