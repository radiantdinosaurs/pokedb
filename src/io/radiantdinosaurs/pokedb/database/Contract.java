package io.radiantdinosaurs.pokedb.database;

/**
 * Created by Bethany Corder on 12/14/2016.
 */
public final class Contract {

    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String DB_URL = "jdbc:mysql://localhost:3306/pokedb";
    static final String USER = "root";
    static final String PASS = "cookiecat25";

    public static final class PokemonTable {
        public static String table_name = "pokemon";
        public static String id = "id";
        public static String types = "types";
        public static String defense = "defense";
        public static String attack = "attack";
        public static String hp = "hp";
        public static String special_defense = "special_defense";
        public static String special_attack = "special_attack";
        public static String speed = "speed";

    }

}
