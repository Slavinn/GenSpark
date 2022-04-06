
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_GUESSES = 6;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private boolean playing;
    private String name;
    private int guesses;

    public GuessTheNumber() {
        this.playing = true;
    }

    public boolean isPlay() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public void getName() {
        System.out.println("Hello! What is your name?");
        setName(scanner.nextLine());
    }

    private void setName(String name) {
        this.name = name;
    }

    private void resetGuesses() {
        this.guesses = 0;
    }
    private  void incrementGuesses() {
        this.guesses++;
    }
    private int getGuesses() {
        return guesses;

    }

    private void game() {

        int secretNumber = random.nextInt(20 + 1) + 1;

        System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");


        while (getGuesses() < MAX_GUESSES) {
            System.out.println(
                    "You have " + (MAX_GUESSES - guesses) + " remaining.\n" +
                            "Take a guess.\n");
            try {
                if (!scanner.hasNextInt()) {
                    throw new Exception("Please enter a number!");
                }
                int guess = scanner.nextInt();
                if (guess == secretNumber) {
                    System.out.println("Good job, " + name + "! You guessed my number in " + (MAX_GUESSES - guesses) + " guesses!");
                    break;
                } else if (guess < secretNumber) {
                    throw new Exception("Your guess is too low.");
                } else if (guess > secretNumber) {
                    throw new Exception("Your guess is too high.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                incrementGuesses();
                scanner.nextLine();
            }

        }
    }
    public void play() {
        while(isPlay()) {
            game();
            setPlaying(playAgain());
        }
    }

    private boolean playAgain() {

        while (true) {
            try {
                System.out.println("Would you like to play again? (y or n)");
                String input = scanner.nextLine();
                if (input.toLowerCase().equals("n")) {
                    return false;
                } else if (input.toLowerCase().equals("y")) {
                    return true;
                } else {
                    throw new Exception("Invalid input please select (y or n)");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
