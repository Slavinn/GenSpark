import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {
    GuessTheNumber guessTheNumber;
    @BeforeEach
    void setUp() {
         guessTheNumber = new GuessTheNumber();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void isPlay() {
        assertEquals(true, guessTheNumber.isPlay());
    }

    @Test
    void setPlayingTrue() {
        guessTheNumber.setPlaying(true);
        assertEquals(true, guessTheNumber.isPlay() );
    }
    @Test
    void setPlayingFalse() {
        guessTheNumber.setPlaying(false);
        assertEquals(false, guessTheNumber.isPlay() );
    }
}