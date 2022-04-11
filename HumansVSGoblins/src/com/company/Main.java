package com.company;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
//        if (!getUserInput("press 1 to start the game")) return;

        Land map = new Land();
        map.buildGrid();


        Human human = new Human();
        human.getCoordinates();

        map.setGridLocation(human.getCoordinates(), human.getIdentifier());

//        human.move();
//        if (!map.inBoundsCheck(coordinates)) {
//            System.out.println("Out of bounds move a different direction");
//        }
//        if (collide(coordinates, map)) {
//            Humanoid humanoid = map.getTileHumanoid(coordinates.get("row"), coordinates.get("column"));
//
//        }
        map.printGrind();
    }
    public static char getNextMove() {
        char input = scanner.next().toLowerCase().charAt(0);
    }

    public static boolean getUserInput(String str) {
        // returns true of 1 is entered.
        System.out.println(str);
        if (scanner.hasNextInt()) {
            if(scanner.nextInt() == 1) {
                return true;
            }
        }
        return false;
    }
}
