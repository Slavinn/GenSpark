import company.Main;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @BeforeEach
    void setUpEach() {
    }

    @Description("Test value 1 as input")
    @Test
    void isValidOne() {
        assertEquals(true, Main.isValid(1));
    }

    @Description("Test value 2 as input")
    @Test
    void isValidTwo() {
        assertEquals(true, Main.isValid(2));
    }

    @Description("Test value 2 as input")
    @Test
    void isValidThree() {
        assertEquals(false, Main.isValid(3));
    }

    @AfterEach
    void tearDown() {

    }
}
