package com.company;

public class Hangman {
    private String randomString;
    private String guessingString;
    private int score;
    private ArrayList<String> hangMan;

    public Hangman() {
        this.randomString = "";
        this.guessingString = "";
        this.score = 0;
        this.hangMan = new ArrayList<>();
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
    }

    public String getGuessingString() {
        return guessingString;
    }

    public void setGuessingString(String guessingString) {
        this.guessingString = guessingString;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<String> getHangMan() {
        return hangMan;
    }

    public void setHangMan(ArrayList<String> hangMan) {
        this.hangMan = hangMan;
    }

    public void randomStringHas
}
