package io.radiantdinosaurs.pokedb.models;

import com.sun.deploy.util.StringUtils;

import java.util.*;

/**
 * TODO: As stated in the {@link Type} class, it's not necessary to provide Javadoc comments for getters + setters.
 * The best cases for having a Javadoc comment on a getter/setter is if it does something more than set/return a value.
 * For example, if you have a setter for an integer, but the value cannot be negative, you may check for negative
 * values and set them to 0 before assigning it to a member variable. Another developer would not know that a method
 * like setAge() would have that extra logic. Of course, this falls onto a different issue altogether, i.e.
 * single responsibility and side effects.
 * - Andrew
 *
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
     * TODO: the method name is somewhat ambiguous.
     * Working in multi-ethnic teams, verbs are often confused with nouns.
     * Here, you mean Types as instances of your Type class.
     * A non-English speaker can read that as types being the verb or a vague reference to
     * types of something else, like egg categories, strategic types, etc.
     *
     * Consider a more universal verb like get, retrieve, or convert.
     * e.g. getTypesAsString, retrieveTypesAsString, convertTypesToString.
     *
     * - Andrew
     *
     * Changes an array of types into a String
     * @return A string of the Pokemon's types
     */
    public String typesToString() {
        String prefix = "";
        StringBuilder sb = new StringBuilder();

        // TODO: using i in a for-each loop makes the intention and logic a little obscured.
        // calling it "pokemonType" instead could be more clear.
        // for example, sb.append(pokemonType) is more clear than sb.append(i)
        // - Andrew
        for(Type i : types){
            sb.append(prefix);
            prefix = ", ";
            // TODO: relying on an object's implicit toString() is harder to notice than seeing the
            // explicit method call. In cases where an argument param is of type Object and the output
            // is a string, it's common to just call the param's toString method. That's why this method works
            // but it's not immediately clear. Even if it's more verbose, using toString() provides more
            // readability.
            // - Andrew
            sb.append(i);
        }
        return sb.toString();
    }
}
