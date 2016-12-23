package io.radiantdinosaurs.pokedb.database;

/**
 * Created by Bethany Corder on 12/14/2016.
 */
public final class Contract {

    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pokedb";
    static final String USER = "root";
    static final String PASS = "cookiecat25";

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
