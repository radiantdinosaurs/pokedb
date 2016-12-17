package io.radiantdinosaurs.pokedb;
import io.radiantdinosaurs.pokedb.database.JSONCreateAndPopulateTable;

/**
 * Created by Bethany Corder on 12/12/2016.
 */
public class PokeDbApp {
    public static void main(String[] args) {
        runProgram();
    }

    public static void runProgram() {
        JSONCreateAndPopulateTable cpt = new JSONCreateAndPopulateTable();
        System.out.println("Creating a connection to the database...");
        cpt.openInitialConnection();
        cpt.checkIfDatabaseExists();
        cpt.checkIfTablesExistInDatabase();
    }
}