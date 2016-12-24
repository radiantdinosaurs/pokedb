package io.radiantdinosaurs.pokedb;
import io.radiantdinosaurs.pokedb.database.CreateDatabaseAndTables;
import io.radiantdinosaurs.pokedb.database.DatabaseReader;
import io.radiantdinosaurs.pokedb.database.DatabaseSeeder;
import io.radiantdinosaurs.pokedb.gui.TableSortFilter;

import java.util.Scanner;

/**
 * A simple database for Pokemon stats
 */
public class PokeDbApp {

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