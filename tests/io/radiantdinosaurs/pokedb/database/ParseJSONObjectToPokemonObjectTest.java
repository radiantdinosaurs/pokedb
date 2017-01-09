package io.radiantdinosaurs.pokedb.database;

import io.radiantdinosaurs.pokedb.models.Pokemon;
import io.radiantdinosaurs.pokedb.models.Type;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author radiantdinosaurs
 */
public class ParseJSONObjectToPokemonObjectTest {
    @Test
    public void createPokemonFromJson() throws Exception {
        String name = "Bethany";
        JSONObject stats = new JSONObject();
        Long statsNum = Long.valueOf(90);
        stats.put("hp", statsNum);
        stats.put("attack", statsNum);
        stats.put("defense", statsNum);
        stats.put("special_attack", statsNum);
        stats.put("special_defense", statsNum);
        stats.put("speed", statsNum);
        List<String> list = new ArrayList<>();
        JSONArray typesArr = new JSONArray();
        list.add("fire");
        list.add("water");
        for(int i = 0; i < list.size(); i++) {
            typesArr.add(list.get(i));
        }
        JSONObject object2 = new JSONObject();
        object2.put("types", typesArr);
        object2.put("stats", stats);
        JSONObject pokemonObject = new JSONObject();
        pokemonObject.put("Bethany", object2);
        Pokemon test;
        ParseJSONObjectToPokemonObject pjpo = new ParseJSONObjectToPokemonObject();
        test = pjpo.createPokemonFromJson(name, pokemonObject);

        // CASE: Parses JSON to a Pokemon object correctly
        assertEquals("Bethany", test.getName());
        assertEquals(90, test.getAttack());
        assertEquals(90, test.getDefense());
        assertEquals(90, test.getHp());
        assertEquals(90, test.getSpecialDefense());
        assertEquals(90, test.getSpecialAttack());
        assertEquals(90, test.getSpeed());
    }

}