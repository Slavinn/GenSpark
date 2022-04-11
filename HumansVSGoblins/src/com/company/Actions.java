package com.company;

import java.util.Hashtable;

public interface Actions {
    public void move(Hashtable<String,Integer> coordinates, Land map);
    public Class attack(Class object);
    public boolean collide(Hashtable<String,Integer> coordinates, Land map);
}
