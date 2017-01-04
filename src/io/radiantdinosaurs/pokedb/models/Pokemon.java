package io.radiantdinosaurs.pokedb.models;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * Model for Pokemon objects
 * @author radiantdinosaurs
 */
public class Pokemon {

    private String name;
    private Type[] types;
    private int defense;
    private int attack;
    private int hp;
    private int specialDefense;
    private int specialAttack;
    private int speed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type[] getTypes() {
        return types;
    }

    public void setTypes(Type[] types) {
        this.types = types;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Changes an array of types into a String
     * @return A string of the Pokemon's types
     */

    public String convertTypesToString() {
        String prefix = "";
        StringBuilder sb = new StringBuilder();
        for(Type pokemonType : types){
            sb.append(prefix);
            prefix = ", ";
            sb.append(pokemonType.toString());
        }
        return sb.toString();
    }
}
