package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
        boolean quit = false;
        int action = 0;
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)\n");

        while (!quit) {
            if(scanner.hasNextInt()) {
                action = scanner.nextInt();
                if (action == 1 || action == 2) {
                    quit = true;
                } else {
                    System.out.println("Invalid input please select (1 or 2)");
                }
            } else {
                System.out.println("Invalid input please select (1 or 2)");
            }
            scanner.nextLine();
        }
        switch (action) {
            case 1:
                System.out.println("You approach the cave..\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Gobbles you down int one bite!");
                break;
            case 2:
                System.out.println("You approach the cave..\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his hand and...\n" +
                        "Offers to share treasure with you");
        }
    }
}
