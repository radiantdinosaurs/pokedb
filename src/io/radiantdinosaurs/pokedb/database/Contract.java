package io.radiantdinosaurs.pokedb.database;

/**
 * Database information
 * @author radiantdinosaurs
 */
final class Contract {

    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pokedb";
    static final String USER = "root";
    static final String PASS = "cookiecat25";

    /**
     * TODO: doesn't seem like these constants are used anywhere.
     * You want to use this PokemonTable contract wherever the values are required
     * such as in CreateDatabaseAndTables#createTablesInDatabase.
     *
     * Otherwise, it's just a redundant class.
     *
     * The benefit to contract classes in a centralized schema that your entire program can use
     *
     * - Andrew
     */
    public static class PokemonTable {
        public static final String table_name = "pokemon";
        public static final String id = "id";
        public static final String name = "name";
        public static final String types = "types";
        public static final String defense = "defense";
        public static final String attack = "attack";
        public static final String hp = "hp";
        public static final String special_defense = "special_defense";
        public static final String special_attack = "special_attack";
        public static final String speed = "speed";

    }

}