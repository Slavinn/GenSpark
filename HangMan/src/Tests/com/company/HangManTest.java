package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HangManTest {
    HangMan hangManGame;

    @BeforeEach
    void setUp() {
        hangManGame = new HangMan();
    }

    @Test
    void getHangMan() {
        ArrayList<String> expectedArray = new ArrayList<>(Arrays.asList(
                "  +---+",
                "      |",
                "      |",
                "      |",
                "      |",
                "      |",
                "======="
        ));
        assertEquals(expectedArray, hangManGame.getHangMan());
    }


    @Test
    void RandomString() {
        hangManGame.setRandomString("cat");
        assertEquals("cat", hangManGame.getRandomString());
    }

    @Test
    void WrongGuesses() {
        hangManGame.setWrongGuesses(2);
        assertEquals(2, hangManGame.getWrongGuesses());
    }

    @Test
    void GuessingStringLength() {
        hangManGame.setGuessingString(5);
        assertEquals("_____", hangManGame.getGuessingString());
    }

    @Test
    void GuessingString() {
        hangManGame.setGuessingString("_a_");
        assertEquals("_a_", hangManGame.getGuessingString());
    }

    @Test
    void alreadyGuessedCharacterTrue() {
        hangManGame.setGuessingString("_a_");
        assertTrue(hangManGame.alreadyGuessedCharacter('a'));
    }
    @Test
    void alreadyGuessedCharacterFalse() {
        hangManGame.setGuessingString("_a_");
        assertFalse(hangManGame.alreadyGuessedCharacter('c'));
    }

    @Test
    void getGuessedLetters() {
        hangManGame.setGuessedLetters('h');
        assertEquals("h", hangManGame.getGuessedLetters());
    }

    @Test
    void validateAndUpdateGuessingStringTrue() {
        hangManGame.setRandomString("cat");
        hangManGame.setGuessingString(3);
        assertTrue(hangManGame.validateAndUpdateGuessingString('c'));
    }
    @Test
    void validateAndUpdateGuessingStringFalse() {
        hangManGame.setRandomString("cat");
        hangManGame.setGuessingString(3);
        assertFalse(hangManGame.validateAndUpdateGuessingString('d'));
    }

    @Test
    void buildHangManCaseOne() {
        hangManGame.buildHangMan(1);
        assertEquals("  O   |", hangManGame.getHangMan().get(1));
    }
    @Test
    void buildHangManCaseTwo() {
        hangManGame.buildHangMan(2);
        assertEquals("  |   |", hangManGame.getHangMan().get(2));
    }
    @Test
    void buildHangManCaseThree() {
        hangManGame.buildHangMan(3);
        assertEquals("  |   |", hangManGame.getHangMan().get(3));
    }
    @Test
    void buildHangManCaseFour() {
        hangManGame.buildHangMan(4);
        assertEquals(" /    |", hangManGame.getHangMan().get(4));
    }
    @Test
    void buildHangManCaseFive() {
        hangManGame.buildHangMan(5);
        assertEquals(" / \\  |", hangManGame.getHangMan().get(4));
    }
    @Test
    void buildHangManCaseSix() {
        hangManGame.buildHangMan(6);
        assertEquals(" \\|   |", hangManGame.getHangMan().get(2));
    }
    @Test
    void buildHangManCaseSeven() {
        hangManGame.buildHangMan(7);
        assertEquals(" \\|/  |", hangManGame.getHangMan().get(2));
    }

    @Test
    void wonTrue() {
        hangManGame.setRandomString("dog");
        hangManGame.setGuessingString("dog");
        assertTrue(hangManGame.won());
    }
    @Test
    void wonFalse() {
        hangManGame.setRandomString("cat");
        hangManGame.setGuessingString("dog");
        assertFalse(hangManGame.won());
    }
}