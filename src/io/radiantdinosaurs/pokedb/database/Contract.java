package io.radiantdinosaurs.pokedb.database;

/**
 * Database information
 * @author radiantdinosaurs
 */
final class Contract {

    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String DB_NAME = "pokedb";
    static final String USER = "root";
    static final String PASS = "cookiecat25";

    public static class PokemonTable {
        public static final String TABLE_NAME = "pokemon";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String TYPES = "types";
        public static final String DEFENSE = "defense";
        public static final String ATTACK = "attack";
        public static final String HP = "hp";
        public static final String SPECIAL_DEFENSE = "special_defense";
        public static final String SPECIAL_ATTACK = "special_attack";
        public static final String SPEED = "speed";

    }

}