package com.example.guihvg.datamodel;

import java.util.Hashtable;

public class Humanoid implements Actions {
    private int health;
    private int strength;
    private Hashtable<String, Integer> coordinates;
    private char identifier;





    public String attack(Humanoid humanoid) {
        return "";
    }

    @Override
    public boolean collide(int row, int column, Land map) {
        return (map.getTileUtf(row, column) == 'G') ? true : false;
    }

    public Humanoid(char identifier) {

        this(100, 10, new Hashtable<>() {{
            put("row", 9);
            put("column", 12);
        }}, identifier);
    }

    public Humanoid(char identifier, int health, int strength) {
        this.identifier = identifier;
        this.health = health;
        this.strength = strength;
        this.coordinates = new Hashtable<>();
//        {{
//            put("row", 9);
//            put("column", 12);
//        }};
    }

    public Humanoid(int health, int strength, Hashtable<String, Integer> coordinates, char identifier) {
        this.health = health;
        this.strength = strength;
        this.coordinates = coordinates;
        this.identifier = identifier;
    }
    public char getIdentifier() {
        return identifier;
    }

    public void setIdentifier(char identifier) {
        this.identifier = identifier;
    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Hashtable<String, Integer> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Hashtable<String, Integer> coordinates) {
        this.coordinates = coordinates;
    }
}
