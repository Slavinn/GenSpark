package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {

    public static Scanner scanner = new Scanner(System.in);
    public String randomString;
    public String guessingString;
    public ArrayList<String> hangMan;
    public int wrongGuesses;
    public String guessedLetters;

    public HangMan() {
        setRandomString();
        setHangMan();
        setGuessedLetters();
        setGuessingString(getRandomString().length());
    }



    public ArrayList<String> getHangMan() {
        return hangMan;
    }

    private void setHangMan() {
        String rowTop = "  +---+";   // "  +---+";
        String rowHead = "      |";  // "  O   |"; index 2
        String rowArms = "      |";  // " \|/  |"; index 1,2,3
        String rowBody = "      |";  // "  |   |"; index 2
        String rowLegs = "      |";  // " / \  |"; index 1,3
        String rowGap = "      |";   // "      |";
        String rowFloor = "======="; // "======="
        this.hangMan = new ArrayList<>();
        this.hangMan.add(rowTop);
        this.hangMan.add(rowHead);
        this.hangMan.add(rowArms);
        this.hangMan.add(rowBody);
        this.hangMan.add(rowLegs);
        this.hangMan.add(rowGap);
        this.hangMan.add(rowFloor);
    }

    private void setHangMan(String string, int index) {
        this.hangMan.set(index, string);
    }

    public String getRandomString() {
        return randomString;
    }

    private void setRandomString() {
        this.randomString = fetchRandomWord();
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    private void setWrongGuesses(int wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }

    public String getGuessingString() {
        return guessingString;
    }

    private void setGuessingString(int length) {
        this.guessingString = new String(new char[length]).replace('\0', '_');
    }

    private void setGuessingString(String updatedString) {
        this.guessingString = updatedString;
    }

    public boolean alreadyGuessedCharacter(char guess) {
        return (getGuessingString().indexOf(guess) != -1);
    }


    public String getGuessedLetters() {
        return guessedLetters;
    }
    private void setGuessedLetters() {
        this.guessedLetters ="";
    }

    public void setGuessedLetters(char guessedLetter) {
        this.guessedLetters += guessedLetter;
    }

    public boolean validateAndUpdateGuessingString(char guess) {
        guess = Character.toLowerCase(guess);
        boolean found = false;
        StringBuilder string = new StringBuilder(getGuessingString());
        for (int i = 0; i < getGuessingString().length(); i++) {
            if (guess == this.randomString.charAt(i)) {
                string.setCharAt(i, guess);
                setGuessingString(string.toString());
                found = true;
            }
        }
        if (!found) {
            setGuessedLetters(guess);
        }
        return found;
    }

    private String fetchRandomWord() {
        try {
            URL connection = new URL("https://random-word-api.herokuapp.com/word?number=1&swear=0");
            HttpURLConnection httpURLConnection = (HttpURLConnection) connection.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                return response.toString();
            } else {
                throw new Exception("Error fetching word from API");
            }


        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void buildHangMan(int guess) {
        switch (guess) {
            case 1:
                setHangMan("  O   |", guess);
                break;
            case 2:
            case 3:
                setHangMan("  |   |", guess);
                break;
            case 4:
                setHangMan(" /    |", guess);
                break;
            case 5:
                setHangMan(" / \\  |", 4);
                break;
            case 6:
                setHangMan(" \\|   |", 2);
                break;
            case 7:
                setHangMan(" \\|/  |", 2);
                break;
            default:
                break;
        }
    }

    public void printHandMan() {
        for (String row : getHangMan()) {
            System.out.println(row);
        }
    }

    private char guessLetter() {
        System.out.println("Missed letters: " + getGuessedLetters());
        System.out.println(getGuessingString());
        System.out.println("Guess a letter.");
        return scanner.next().charAt(0);
    }

    public boolean won() {
        return getRandomString().equals(getGuessingString());
    }

    public void play() {
        System.out.println("H A N G M A N");
        HangManGameLoop();
    }

    private void HangManGameLoop() {
        char guess;
        while (true) {
            printHandMan();
            if (getWrongGuesses() >= 7) {
                String lost = String.format("You lost :(! The secret word is \"%s\"! Better luck next time!", getRandomString());
                System.out.println(lost);
                break;
            }
            guess = guessLetter();
            if (alreadyGuessedCharacter(guess)) {
                System.out.println("You already guessed that letter. Choose again");
            } else if (!validateAndUpdateGuessingString(guess)) {
                setWrongGuesses(getWrongGuesses() + 1);
                buildHangMan(getWrongGuesses());
            } else if (won()) {
                String winner = String.format("Yes! The secret word is \"%s\"! You have won!", getRandomString());
                System.out.println(winner);
                break;
            }

        }
    }

}
