package io.radiantdinosaurs.pokedb.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author radiantdinosaurs
 */
public class PokemonTest {
    @Test
    public void convertTypesToString() throws Exception {
        String[] typesArray = {"fire", "ice"};
        Type[] types = new Type[typesArray.length];
        for(int i = 0; i < types.length; i++) {
            Type type = new Type();
            type.setTypeName(typesArray[i]);
            types[i] = type;
        }
        Pokemon pokemon = new Pokemon();
        pokemon.setTypes(types);
        String actual = pokemon.convertTypesToString();
        String expected = "fire, ice";
        assertEquals(actual, expected);

    }
}