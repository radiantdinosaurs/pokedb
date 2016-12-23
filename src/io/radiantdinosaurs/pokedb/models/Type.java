package io.radiantdinosaurs.pokedb.models;

/**
 * Created by Bethany Corder on 12/14/2016.
 */
public class Type {

    private String typeName;

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String toString() {
        return typeName;
    }
}