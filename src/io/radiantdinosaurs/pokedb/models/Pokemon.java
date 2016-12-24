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

    /**
     * Gets the name of the Pokemon
     * @return the name of the Pokemon
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Pokemon
     * @param name the name of the Pokemon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the types of the Pokemon
     * @return the types of the Pokemon
     */
    public Type[] getTypes() {
        return types;
    }

    /**
     * Sets the types of the Pokemon
     * @param types the types of the Pokemon
     */
    public void setTypes(Type[] types) {
        this.types = types;
    }

    /**
     * Gets the defense of the Pokemon
     * @return the defense of the Pokemon
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the defense of the Pokemon
     * @param defense the defense of the Pokemon
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Gets the attack of the Pokemon
     * @return the attack of the Pokemon
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Sets the attack of the Pokemon
     * @param attack the attack of the Pokemon
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Gets the hp of the Pokemon
     * @return the hp of the Pokemon
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the hp of the Pokemon
     * @param hp the hp of the Pokemon
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Gets the special defense of the Pokemon
     * @return the special defense of the Pokemon
     */
    public int getSpecialDefense() {
        return specialDefense;
    }

    /**
     * Sets the special defense of the Pokemon
     * @param specialDefense the special defense of the Pokemon
     */
    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    /**
     * Gets the special defense of the Pokemon
     * @return the special defense of the Pokemon
     */
    public int getSpecialAttack() {
        return specialAttack;
    }

    /**
     * Sets the special attack of the Pokemon
     * @param specialAttack the special attack of the Pokemon
     */
    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    /**
     * Gets the speed of the Pokemon
     * @return the speed of the Pokemon
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets the speed of the Pokemon
     * @param speed the speed of the Pokemon
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Changes an array of types into a String
     * @return A string of the Pokemon's types
     */
    public String typesToString() {
        String prefix = "";
        StringBuilder sb = new StringBuilder();
        for(Type i : types){
            sb.append(prefix);
            prefix = ", ";
            sb.append(i);
        }
        return sb.toString();
    }
}
