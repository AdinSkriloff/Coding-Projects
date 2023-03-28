/**
 * Implements the board of Shortcut Scrabble.
 * 
 * @author stewarmc
 * @version s23
 *
 */
public class Board {

    private Letter[] board;

    private int[] pointMult;

    /**
     * Construct a Shortcut Scrabble board with the provided multipliers.
     * @param multiplier array of bonus multipliers
     */
    public Board(int[] multiplier) {

        board = new Letter[multiplier.length];

        pointMult = new int[multiplier.length];

        for (int i = 0; i < multiplier.length; i++) {

            pointMult[i] = multiplier[i];

        }
    }

    /**
     * Get the letter at the indicated index.
     * @param index the position of the desired Letter
     * @return the Letter in the board at the position identified by index
     */
    public Letter getLetter(int index) {

        return board[index];

    }

    /**
     * Get the multiplier at index.
     * @param index location of multiplier
     * @return multiplier
     */
    public int getPointMult(int index) {

        return pointMult[index];

    }

    /**
     * Get the Shortcut Scrabble score of the whole board.
     * @return sum
     */
    public int getBoardScore() {

        int total = 0;

        for (int i = 0; i < board.length; i++) {

            total += getLetterScore(i);

        }

        return total;

    }

    /**
     * Play Letter at index.
     * @param letter to be played
     * @param index at which to play
     * @return success
     */
    public boolean play(Letter letter, int index) {

        if (index >= 0 && index < board.length && board[index] == null) {

            board[index] = letter;

            return true;

        }

        return false;

    }

    /**
     * Get the Shortcut Scrabble score for the position at index.
     * @param index location to score
     * @return score (with multiplier applied)
     */
    public int getLetterScore(int index) {

        if (index >= 0 && index < board.length && board[index] != null) {
            return board[index].getPoints() * pointMult[index];
        }
        return 0;

    }

    /**
     * String rep of board.
     * @return a string representation of the Board.
     */
    public String toString() {

        String str = "";

        for (int i = 0; i < board.length; i++) {
            if (board[i] != null) {
                str += i + ": " + board[i].toString() + "; ";
            } else {
                str += i + ": -; ";
            }

        }

        return str;

    }

}