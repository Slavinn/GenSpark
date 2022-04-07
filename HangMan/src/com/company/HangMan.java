package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {

    private static Scanner scanner = new Scanner(System.in);
    private String randomString;
    private String guessingString;
    private ArrayList<String> hangMan;
    private int wrongGuesses;

    public HangMan() {
        System.out.println("H A N G M A N");
        setRandomString();
        setHangMan();
        setGuessingString(getRandomString().length());
    }

    public ArrayList<String> getHangMan() {
        return hangMan;
    }

    public void setHangMan() {
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

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString() {
        this.randomString = fetchRandomWord();
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public void setWrongGuesses(int wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }

    public String getGuessingString() {
        return guessingString;
    }
    public void setGuessingString(int length) {
        this.guessingString = new String(new char[length]).replace('\0', '_');
    }

    public void setGuessingString(String updatedString) {
        this.guessingString = updatedString;
    }

    public boolean validateAndUpdateGuessingString(char guess) {
        guess = Character.toLowerCase(guess);
        StringBuilder string = new StringBuilder(getGuessingString());
        for (int i = 0; i < getGuessingString().length(); i++) {
            if (guess == this.randomString.charAt(i)) {
                string.setCharAt(i, guess);
                setGuessingString(string.toString());
                return true;
            }
        }
        return false;
    }

    private String fetchRandomWord() {
        return "cat";
//        try {
//            URL connection = new URL("https://random-word-api.herokuapp.com/word?number=1&swear=0");
//            HttpURLConnection httpURLConnection = (HttpURLConnection) connection.openConnection();
//            httpURLConnection.setRequestMethod("GET");
//            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//            int responseCode = httpURLConnection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) { // success
//                BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                // print result
//                return response.toString();
//            } else {
//                throw new Exception("Error fetching word from API");
//            }
//
//
//        } catch (Exception e) {
//            return e.getMessage();
//        }
    }

    private void buildHangMan(int guess) {
        switch (guess) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                break;
        }
   }

   private void printHandMan() {
       for (String row: getHangMan()) {
           System.out.println(row);
       }
   }
   private char guessLetter() {
       System.out.println("Missed letters:");
       System.out.println(getGuessingString());
       System.out.println("Guess a letter.");
       return scanner.next().charAt(0);
   }

   private boolean won() {
       return getRandomString().equals(getGuessingString());
   }
   public void play() {
        HangManGameLoop();
   }

    private void HangManGameLoop() {
        char guess;
        while (getWrongGuesses() < 7) {
            printHandMan();
            guess = guessLetter();
            if(!validateAndUpdateGuessingString(guess)) {
                setWrongGuesses(getWrongGuesses() + 1);
            } else if (won()) {
                String winner = String.format("Yes! The secret word is \"%s\"! You have won!",getRandomString());
                System.out.println(winner);
                break;
            }

        }
    }


}
