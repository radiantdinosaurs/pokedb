package io.radiantdinosaurs.pokedb.models;

/**
 * Model for Pokemon types
 * @author radiantdinosaurs
 */
public class Type {

    private String typeName;

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return typeName;
    }
}