package io.radiantdinosaurs.pokedb.database;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Bethany Corder on 12/22/2016.
 */
public class ParseJSON {

    public static final String filePath = "C:\\Users\\Bethany Corder\\Google Drive\\Coding Projects\\IntelliJ IDEA Projects\\PokeDB\\src\\io\\radiantdinosaurs\\pokedb\\assets\\pokemon.json";

    public static Object parseJson() {
        JSONParser parser = new JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            return obj;
        }
    }
}
