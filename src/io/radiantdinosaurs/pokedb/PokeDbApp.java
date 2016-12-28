package io.radiantdinosaurs.pokedb;
import io.radiantdinosaurs.pokedb.database.CreateDatabaseAndTables;
import io.radiantdinosaurs.pokedb.database.DatabaseReader;
import io.radiantdinosaurs.pokedb.database.DatabaseSeeder;
import io.radiantdinosaurs.pokedb.gui.TableSortFilter;

import java.util.Scanner;

/**
 * TODO: provide a better description for this app. This app isn't exactly a database, though it does use one.
 * A simple database for Pokemon stats
 */
public class PokeDbApp {

    /**
     * TODO: given that this class only has one other method besides the main method, it's not necessary to keep
     * that logic separated.
     */
    public static void main(String[] args) {
        runProgram();
    }

    private static void runProgram() {
        CreateDatabaseAndTables cpt = new CreateDatabaseAndTables();
        DatabaseSeeder ds = new DatabaseSeeder();
        DatabaseReader dq = new DatabaseReader();
        cpt.checkIfDatabaseExists();
        cpt.createTablesInDatabase();
        ds.insertPokemonIntoDatabase();
        new TableSortFilter();
    }
}