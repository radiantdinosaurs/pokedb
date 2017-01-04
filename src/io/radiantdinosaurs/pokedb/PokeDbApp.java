package io.radiantdinosaurs.pokedb;
import io.radiantdinosaurs.pokedb.database.*;
import io.radiantdinosaurs.pokedb.gui.PokemonStatsTableWithSearchView;

/**
 * A simple program that uses a database to list (and allow the user to filter) the names, types, and stats of Pokemon.
 */
public class PokeDbApp {

    public static void main(String[] args) {
        CreateDatabase cd = new CreateDatabase();
        CreateTables ct = new CreateTables();
        DatabaseSeeder ds = new DatabaseSeeder();
        cd.createDatabase();
        ct.createTablesInDatabase();
        ds.insertPokemonIntoDatabase();
        new PokemonStatsTableWithSearchView();
    }
}