package com.company;

import java.util.Hashtable;

public class Human extends Humanoid{

    public Human() {
        super('H');
    }

    public Human(int health, int strength) {
        super(health, strength);
    }

    public Human(int health, int strength, Hashtable<String, Integer> coordinates) {
        super(health, strength, coordinates, 'H');
    }
}
