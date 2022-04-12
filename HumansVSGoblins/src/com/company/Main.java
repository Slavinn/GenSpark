package com.company;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
//

        Land map = new Land();
        Human human = new Human();
        Goblin goblin = null;

        map.buildGrid();
        human.getCoordinates();

        map.setGridLocation(human.getCoordinates(), human.getIdentifier());
        populateMap(map);

        while (human.getHealth() > 0) {
            map.printGrind();
            goblin = getNextMove(human, map);
            if (goblin != null) {
                System.out.println("You encountered Goblin!!!\n");
                while(true) {
                    if (!getUserInput( "Press 1 to attack!\n" +
                            "Press 2 to flee...COWARD!\n")) break;
                    if(human.getHealth() > 0) {
                        human.attack(goblin);
                    } else {
                        System.out.println("Game over!");
                        break;
                    }
                    if (goblin.getHealth() > 0) {
                        goblin.attack(human);
                    } else {
                        map.move(human, goblin);
                        break;
                    }

                }
            }
        }
    }

    public static void populateMap(Land map) {
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j < 25; j++) {
                Long randomRow =  Math.round(1+ (Math.random() * 10));
                if ( randomRow == 9 ) {
                    Hashtable<String, Integer> coords = new Hashtable<>();
                    coords.put("row", i);
                    coords.put("column", j);
                    Goblin goblin = new Goblin();
                    goblin.setCoordinates(coords);
                    map.setTileUTF(i,j, goblin.getIdentifier());
                    map.setTileHumanoid(i,j, goblin);

                }

            }
        }
    }

    public static Goblin getNextMove(Human human, Land map) {
        Hashtable<String, Integer> coords = human.getCoordinates();
        int row = coords.get("row");
        int column = coords.get("column");
        char input = scanner.next().toLowerCase().charAt(0);
        return map.move(human, input);
    }

    public static boolean getUserInput(String str) {
        // returns true of 1 is entered.
        System.out.println(str);
        if (scanner.hasNextInt()) {
            if (scanner.nextInt() == 1) {
                return true;
            }
        }
        return false;
    }
}
