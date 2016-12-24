package io.radiantdinosaurs.pokedb.database;

import io.radiantdinosaurs.pokedb.models.Pokemon;
import io.radiantdinosaurs.pokedb.models.Type;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import static java.lang.Math.toIntExact;

/**
 * Parses JSON objects into Pokemon objects
 * @author radiantdinosaurs
 */
class ParseObjectJSON {

    /**
     * Creates a Pokemon object from a JSON object
     * @param key contains the name of Pokemon
     * @param jsonObject contains information about the Pokemon
     * @return a Pokemon object
     */
    static Pokemon createPokemonFromJson(Object key, JSONObject jsonObject) {
        String pokemonName = (String) key;
        //Obtaining the Pokemon's information using the Pokemon's name
        JSONObject pokemonInformation = (JSONObject) jsonObject.get(pokemonName);
        //Creating a Pokemon object
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonName);
        pokemon.setTypes(getTypesFrom(pokemonInformation.get("types")));
        //Getting the stats (attack, hp, etc.) from the Pokemon's information
        JSONObject pokemonStats = (JSONObject) pokemonInformation.get("stats");
        Long attack = (Long) pokemonStats.get("attack");
        pokemon.setAttack(toIntExact(attack));
        Long defense = (Long) pokemonStats.get("defense");
        pokemon.setDefense(toIntExact(defense));
        Long hp = (Long) pokemonStats.get("hp");
        pokemon.setHp(toIntExact(hp));
        Long specialDefense = (Long) pokemonStats.get("special_defense");
        pokemon.setSpecialDefense(toIntExact(specialDefense));
        Long specialAttack = (Long) pokemonStats.get("special_attack");
        pokemon.setSpecialAttack(toIntExact(specialAttack));
        Long speed = (Long) pokemonStats.get("speed");
        pokemon.setSpeed(toIntExact(speed));
        return pokemon;
    }

    /**
     *
     * @param pokemonTypes contains the Pokemon's types
     * @return array of the Pokemon's types
     */
    private static Type[] getTypesFrom(Object pokemonTypes) {
        String[] typesStringArray = getStringArray((JSONArray) pokemonTypes);
        Type[] types = new Type[typesStringArray.length];
        for(int i = 0; i < types.length; i++) {
            Type type = new Type();
            type.setTypeName(typesStringArray[i]);
            types[i] = type;
        }
        return types;
    }

    /**
     * Changes the JSON array of the Pokemon's types into a String array
     * @param pokemonTypesJsonArray a JSON array containing the Pokemon's types
     * @return String array of the Pokemon's types
     */
    private static String[] getStringArray(JSONArray pokemonTypesJsonArray) {
        int length = pokemonTypesJsonArray.size();
        String[] typesStringArray = new String[length];
        for(int i = 0; i < length; i++) {
            typesStringArray[i] = (String) pokemonTypesJsonArray.get(i);
        }
        return typesStringArray;
    }
}