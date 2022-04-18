package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        Hangman game = new Hangman();
        game.setHangMan();
        int guesses = 0;
        boolean newGame = false;
        System.out.println("Please enter name for the scoreBoard");
        game.setName(scanner.nextLine());
        while(!newGame) {
            try {
                game.getHangMan().stream().forEach(System.out::println);
                System.out.println("Missed letters: " + game.getWrongGuesses());
                System.out.println(game.getGuessingString());
                System.out.println("Guess a letter:");
                char guessChar  = scanner.nextLine().charAt(0);

                if((game.randomStringHasCharacter(guessChar)) > -1) {
                    game.setGuessingString( guessChar);
                    game.setScore(10 - guesses);
                } else {
                    guesses++;
                    game.buildHangMan(guesses);
                   game.setWrongGuesses(guessChar);
                }
                if(guesses >= 7) {
                    String lost = String.format("You lost :(! The secret word is \"%s\"! Better luck next time!", game.getRandomString());
                    System.out.println(lost);
                    newGame = true;
                } else if (game.compareStrings()) {
                    String winner = String.format("Yes! The secret word is \"%s\"! You have won!", game.getRandomString());
                    System.out.println(winner);
                    newGame = true;
                }
                if (newGame) {
                    System.out.println("You scored: " + game.getScore());
                    game.addScores();
                    game.getScores();
                    System.out.println("Do you want to play again? (yes or no)");
                    String output = scanner.nextLine();
                    if (output.equalsIgnoreCase("yes")) {
                        game = new Hangman();
                        game.setHangMan();
                        guesses = 0;
                        System.out.println("Please enter name for the scoreBoard");
                        game.setName(scanner.nextLine());
                        newGame = false;
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }


}
