package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here

        HangMan hangManGame = new HangMan();

        while (true) {
            hangManGame.play();
            System.out.println("Do you want to play again? (yes or no)");
            String output = scanner.nextLine();
            if (output.toLowerCase().equals("no")) {
                break;
            } else if (output.toLowerCase().equals("yes")) {
                   hangManGame = new HangMan();
            }

        }
        scanner.close();
    }

}
