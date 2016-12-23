package io.radiantdinosaurs.pokedb.database;
import io.radiantdinosaurs.pokedb.models.Pokemon;
import io.radiantdinosaurs.pokedb.models.Type;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static java.lang.Math.toIntExact;

/**
 * Created by Bethany Corder on 12/14/2016.
 */
public class ReadFromFileJSON {

    public static Pokemon createPokemonObjectsFromJsonFile(Object key, JSONObject jsonObject) {
            String name = (String) key;
            JSONObject pokemonObj = (JSONObject) jsonObject.get(name);
            Pokemon pokemon = new Pokemon();
            pokemon.setName(name);
            pokemon.setTypes(getTypesFrom(pokemonObj.get("types")));
            JSONObject statsObj = (JSONObject) pokemonObj.get("stats");
            Long attack = (Long) statsObj.get("attack");
            pokemon.setAttack(toIntExact(attack));
            Long defense = (Long) statsObj.get("defense");
            pokemon.setDefense(toIntExact(defense));
            Long hp = (Long) statsObj.get("hp");
            pokemon.setHp(toIntExact(hp));
            Long specialDefense = (Long) statsObj.get("special_defense");
            pokemon.setSpecialDefense(toIntExact(specialDefense));
            Long specialAttack = (Long) statsObj.get("special_attack");
            pokemon.setSpecialAttack(toIntExact(specialAttack));
            Long speed = (Long) statsObj.get("speed");
            pokemon.setSpeed(toIntExact(speed));
            return pokemon;
    }


    private static Type[] getTypesFrom(Object arrObj) {
        String[] typesArr = getStringArray((JSONArray) arrObj);
        Type[] types = new Type[typesArr.length];

        for(int i = 0; i < types.length; i++) {
            Type type = new Type();
            type.setTypeName(typesArr[i]);
            types[i] = type;
        }
        return types;
    }

    public static String[] getStringArray(JSONArray jArr) {
        int length = jArr.size();
        String[] stringArr = new String[length];
        for(int i = 0; i < length; i++) {
            stringArr[i] = (String) jArr.get(i);
        }
        return stringArr;
    }
}