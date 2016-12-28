package io.radiantdinosaurs.pokedb.models;

/**
 * Model for Pokemon types
 * @author radiantdinosaurs
 */
public class Type {

    /**
     * TODO: you should provide a getter for this variable.
     * Relying on toString for exact values is not recommended practice.
     * - Andrew
     */
    private String typeName;

    /**
     * TODO: (opinion) if your method is a getter or setter, it's not necessary to provide a Javadoc comment.
     * - Andrew
     *
     * Sets the name of the type
     * @param typeName name of the type
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}