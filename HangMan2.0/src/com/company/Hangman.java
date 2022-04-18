package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hangman {
    private String randomString;
    private StringBuilder guessingString;
    private String wrongGuesses;
    private ArrayList<String> hangMan;
    private ArrayList<String> scoreBoard;
    private String name;
    private int score;
    private File highscores = new File("src/Gamefiles/highScores.txt");


    public Hangman() {
        try{
            fetchRandomWord();
            setGuessingString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.wrongGuesses = "";
        this.score = 0;
        this.hangMan = new ArrayList<>();
        this.name = "";

    }

    public void setHangMan() {
        try {
            Stream<String> fileStream = Files.lines(Paths.get("src/Gamefiles/assets.txt"));
            this.hangMan = (ArrayList<String>) fileStream.collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    public String getWrongGuesses() {
        return wrongGuesses;
    }

    public void setWrongGuesses(char wrongGuesses) {
        this.wrongGuesses += wrongGuesses;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString.toLowerCase();
    }

    public StringBuilder getGuessingString() {
        return guessingString;
    }

    public void setGuessingString() {
        int l = getRandomString().length();
        String str = new String(new char[l]).replace('\0', '_');
        this.guessingString = new StringBuilder(str);
    }

    public void setGuessingString(char letter) {
        IntStream value = IntStream.range(0,this.randomString.length()).filter(l -> this.randomString.charAt(l) == letter);
        value.forEach(i -> this.guessingString.setCharAt(i, letter));
    }

    public void getScores() {
        try {
            if (!this.highscores.exists()) {
                this.highscores.createNewFile();
            }
            Stream<String> fileStream = Files.lines(Paths.get(this.highscores.getPath()));
            System.out.println("Top scores: ");
            fileStream.sorted((s1, s2) -> s2.split(" ")[0].compareTo(s1.split(" ")[0])).forEach(System.out::println);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addScores() {
        try{
            Files.writeString(this.highscores.toPath(), String.format("%s %s\n", getScore(),getName()), StandardOpenOption.APPEND);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public ArrayList<String> getHangMan() {
        return hangMan;
    }

    public void setHangMan(ArrayList<String> hangMan) {
        this.hangMan = hangMan;
    }

    public int randomStringHasCharacter(char letter) {
        return this.randomString.indexOf(letter);
    }

    private void setHangMan(String string, int index) {
        this.hangMan.set(index, string);
    }

    public boolean compareStrings() {
        return getRandomString().equals(getGuessingString().toString());
    }


    public void buildHangMan(int guesses) {

        switch (guesses) {
            case 1:
                setHangMan("  O   |", guesses);
                break;
            case 2:
            case 3:
                setHangMan("  |   |", guesses);
                break;
            case 4:
                setHangMan(" /    |", guesses);
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

    public void fetchRandomWord() {
        try {
            URL connection = new URL("https://random-word-api.herokuapp.com/word?number=1");
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

                //Set RandomString to result
                setRandomString(response.toString());
            } else {
                throw new Exception("Error fetching word from API");
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
