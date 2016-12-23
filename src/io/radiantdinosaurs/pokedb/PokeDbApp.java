package io.radiantdinosaurs.pokedb;
import io.radiantdinosaurs.pokedb.database.CreateDatabaseAndTables;
import io.radiantdinosaurs.pokedb.database.DatabaseSeeder;

/**
 * Created by Bethany Corder on 12/12/2016.
 */
public class PokeDbApp {
    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        CreateDatabaseAndTables cpt = new CreateDatabaseAndTables();
        DatabaseSeeder ds = new DatabaseSeeder();
        System.out.println("Creating a connection to the database...");
        cpt.openInitialConnection();
        cpt.checkIfDatabaseExists();
        cpt.checkIfTablesExistInDatabase();
        ds.checkIfTablesAreFilled();
    }
}