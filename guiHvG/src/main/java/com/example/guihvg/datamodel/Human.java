package com.example.guihvg.datamodel;

import java.util.Hashtable;

public class Human extends Humanoid{

    public Human() {
        super('H');
    }


    public String attack(Goblin goblin) {
        int attackDMG = Math.toIntExact(Math.round(Math.random() * getStrength()));
        int remainingHealth = goblin.getHealth() - attackDMG;
        goblin.setHealth(remainingHealth);
        return String.format("You attack the Goblin for " + attackDMG +" damage!\n") + goblin;
    }

    @Override
    public boolean collide(int row, int column, Land map) {
        return super.collide(row, column, map);
    }

    public Human(char identifier) {
        super(identifier);
    }

    public Human(char identifier, int health, int strength) {
        super(identifier,health, strength);
    }

    public Human(int health, int strength, Hashtable<String, Integer> coordinates, char identifier) {
        super(health, strength, coordinates, identifier);
    }

    @Override
    public char getIdentifier() {
        return super.getIdentifier();
    }

    @Override
    public void setIdentifier(char identifier) {
        super.setIdentifier(identifier);
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
    }

    @Override
    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    @Override
    public Hashtable<String, Integer> getCoordinates() {
        return super.getCoordinates();
    }

    @Override
    public void setCoordinates(Hashtable<String, Integer> coordinates) {
        super.setCoordinates(coordinates);
    }

    public Human(int health, int strength, Hashtable<String, Integer> coordinates) {
        super(health, strength, coordinates, 'H');
    }

    @Override
    public String toString() {
        if (getHealth() > 0) {
            return "You have " + getHealth() + " health remaining\n";
        }
        return "You died from that attack\n";
    }
}
