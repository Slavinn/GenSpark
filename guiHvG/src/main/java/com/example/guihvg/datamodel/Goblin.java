package com.example.guihvg.datamodel;

import java.util.Hashtable;

public class Goblin extends Humanoid {



    public void attack(Human human) {
        int attackDMG = Math.toIntExact(Math.round(Math.random() * getStrength()));
        System.out.println("The Goblin attacks you for " + attackDMG +" damage!");
        int remainingHealth = human.getHealth() - attackDMG;
        human.setHealth(remainingHealth);
        if (human.getHealth() <= 0 ){
            System.out.println(human.toString());
        } else {
            System.out.println(human.toString());
        }

    }

    @Override
    public boolean collide(int row, int column, Land map) {
        return super.collide(row, column, map);
    }

    public Goblin() {
        super('G', 10,5);
    }

    public Goblin(char identifier,int health, int strength) {
        super(identifier,health, strength);
    }

    public Goblin(int health, int strength, Hashtable<String, Integer> coordinates, char identifier) {
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

    @Override
    public String toString() {
        if (getHealth() > 0) {
            return "The Goblin has " + getHealth() + " health remaining\n";
        }
        return "The Goblin has died from that attack\n";
    }

}
