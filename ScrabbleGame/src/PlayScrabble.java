import java.util.Random;
import java.util.Scanner;

/**
 * Driver class for Shortcut Scrabble.
 * @author stewarmc
 * @version s23
 */
public class PlayScrabble {

    /**
     * Runs the program.
     * @param args unused in this program.
     */
    public static void main(String[] args) {
        System.out.println("*** Welcome To Shortcut Scrabble ***");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        int[] multipliers = { 3, 1, 2, 1, 1, 2, 1, 3 };
        Board board = new Board(multipliers);

        Hand hand = new Hand();
        buildHand(hand);

        while (true) {
            System.out.println("=========================================================");
            System.out.println("The board:");
            printBoard(board, multipliers);
            System.out.println();
            System.out.println("Your hand:");
            printHand(hand);
            System.out.println("=========================================================");
            System.out.println();
            System.out.println("Where would you like to move? (0-7, 8 to quit)");
            int move = getMove(scanner);
            if (move == 8) {
                break;
            }
            System.out.println("What letter would you like to play?");
            char letter = Character.toLowerCase(getPlay(scanner));

            int index = hand.indexOf(letter);
            if (index == -1) {
                System.out.println("That letter isn't in your hand!");
            } else {
                Letter letterToPlay = hand.remove(index);
                boolean success = board.play(letterToPlay, move);
                if (!success) {
                    hand.insert(letterToPlay, index);
                    System.out.println("Illegal move. Try again.");
                } else {
                    hand.remove(index);
                    System.out.println("Played " + letterToPlay + " at position " + move);
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Bye!");
    }

    /**
     * Populates hand with random Letters.
     * @param hand reference to populate with Letters
     */
    private static void buildHand(Hand hand) {
        Random rnd = new Random();
        for (int i = 0; i < 8; i++) {
            char letter = (char) ('a' + rnd.nextInt(26));
            int points = rnd.nextInt(5);
            hand.insert(new Letter(letter, points), i);
        }
    }

    /**
     * Get the player's intent.
     * @param scanner parses the input
     * @return char representing their intent
     */
    private static char getPlay(Scanner scanner) {
        return scanner.nextLine().charAt(0);
    }

    /**
     * Location the player wishes to choose.
     * @param scanner parses player's input
     * @return int of the request location
     */
    private static int getMove(Scanner scanner) {
        int nextInt = scanner.nextInt();
        scanner.nextLine();
        return nextInt;
    }

    /**
     * Prints the hand to the console.
     * @param hand to be printed
     */
    private static void printHand(Hand hand) {
        System.out.println(hand);
    }

    /**
     * Prints the state of the board.
     * @param board to be printed
     * @param multipliers that affect the scoring of the board
     */
    private static void printBoard(Board board, int[] multipliers) {
        System.out.print("Entries:     ");
        for (int i = 0; i < 8; i++) {
            Letter l = board.getLetter(i);
            if (l == null) {
                System.out.print("-");
            } else {
                System.out.print(l.getLetter());
            }
        }

        System.out.println();
        System.out.print("Multipliers: ");
        for (int i = 0; i < 8; i++) {
            System.out.print(multipliers[i]);
        }
        System.out.println();
        System.out.println("Points: " + board.getBoardScore());
        System.out.println();
    }

}
