package company;

import java.util.Scanner;

public class Main {

    private static  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here

        boolean quit = false;
        int cave;
        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "and will share his treasure with you. The other dragon\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)\n");
        cave = chooseCave(quit);
        getCave(cave);
        scanner.close();
    }

    public static int chooseCave(boolean choosing) {
        int cave = 0;
        while (!choosing) {
            try {
                scanner.hasNextInt();
                cave = scanner.nextInt();
                choosing = isValid(cave);
            } catch (Exception e) {
                System.out.println("Invalid input please select (1 or 2)");
            } finally {
                scanner.next();
            }
        }
        return cave;
    }

    public static boolean isValid(int num) {
        return (num == 1 || num == 2);
    }

    public static void getCave(int cave) {
        switch (cave) {
            case 1:
                System.out.println("You approach the cave..\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his jaws and...\n" +
                        "Gobbles you down int one bite!");
                break;
            case 2:
                System.out.println("You approach the cave..\n" +
                        "It is dark and spooky...\n" +
                        "A large dragon jumps out in front of you! He opens his hand and...\n" +
                        "Offers to share treasure with you");
                break;
            default:
                break;
        }
    }
}
