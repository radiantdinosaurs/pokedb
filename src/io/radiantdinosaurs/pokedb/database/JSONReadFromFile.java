package io.radiantdinosaurs.pokedb.database;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by Bethany Corder on 12/14/2016.
 */
public class JSONReadFromFile {

    public static final String filePath = "C:\\Users\\Bethany Corder\\Google Drive\\Coding Projects\\IntelliJ IDEA Projects\\PokeDB\\src\\io\\radiantdinosaurs\\pokedb\\assets\\pokemon.json";

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));
        JSONObject jsonObject = (JSONObject) obj;
        printJsonObject(jsonObject);
    }

    public static void printJsonObject(JSONObject jsonObj) {
        for(Object key : jsonObj.keySet()) {
            String keyStr = (String)key;
            Object keyValue = jsonObj.get(keyStr);
            System.out.println("key: "+ keyStr);
            System.out.println("value: " + keyValue);
//            if(keyValue instanceof JSONObject)
//                printJsonObject((JSONObject)keyValue);
        }
    }
}