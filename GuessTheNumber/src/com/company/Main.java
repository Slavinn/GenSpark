package com.company;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int MAX_GUESSES = 6;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        // write your code her

        boolean play = true;
        String name = getName();
        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
        guessTheNumber(name);
        while (play) {
            try {

                String input = scanner.nextLine();
                if (input.toLowerCase().equals("n")) {
                    play = false;
                } else if (input.toLowerCase().equals("y")) {
                    guessTheNumber(name);
                } else {
                    throw new Exception("Invalid input please select (y or n)");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void guessTheNumber(String name) {
        int guesses = 0;
        int secrentNumber = random.nextInt(20 + 1) + 1;
        while (guesses < MAX_GUESSES) {
            System.out.println(
                    "You have " + (MAX_GUESSES - guesses) + " remaining.\n" +
                            "Take a guess.\n");
            try {
                if (!scanner.hasNextInt()) {
                    throw new Exception("Please enter a number!");
                }
                int guess = scanner.nextInt();
                if (guess == secrentNumber) {
                    System.out.println("Good job, " + name + "! You guessed my number in " + (MAX_GUESSES - guesses) + " guesses!");
                    break;
                } else if (guess < secrentNumber) {
                    throw new Exception("Your guess is too low.");
                } else if (guess > secrentNumber) {
                    throw new Exception("Your guess is too high.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                guesses++;
                scanner.nextLine();
            }

        }
        System.out.println("Would you like to play again? (y or n)");

    }

    public static String getName() {
        System.out.println("Hello! What is your name?");
        return scanner.nextLine();
    }
}
