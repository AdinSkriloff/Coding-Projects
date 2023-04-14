/**
 * The Hand class.
 *
 * @author adins
 * @version 02-02-2023
 */

public class Hand {
    public static final int MAX_SIZE = 8;
    private Letter[] hand;
    private int size;

    /**
     * A no arg constructor.
     */
    public Hand() {

        this.size = MAX_SIZE;
        this.hand = new Letter[MAX_SIZE];
    }

    /**
     * The hand method.
     *
     * @param size is an int
     */

    public Hand(int size) {
        int valuedSize = size;
        // validation
        if (valuedSize < 0) {
            valuedSize = 0;

        } else if (valuedSize > MAX_SIZE) {
            valuedSize = MAX_SIZE;
        }

        this.size = valuedSize;
        this.hand = new Letter[this.size];

    }

    public int getSize() {
        return size;
    }

    /**
     * One arg construtor.
     *
     * @param index is an int
     * @return the index of the hand field
     */

    public Letter getLetter(int index) {
        return this.hand[index];
    }

    // If index is within range and there is not another letter in the hand at index, the letter should be inserted into
    // the hand at index and return true.
    // If those conditions do not hold, false should be returned
    /**
     * The insert method.
     *
     * @param letter is a Letter array
     * @param index is an int
     * @return boolean
     */
    public boolean insert(Letter letter, int index) {

        if (index < this.hand.length && index >= 0) {
            if (this.hand[index] == null) {
                this.hand[index] = letter;
                return true;
            }

        }
        return false;

    }

    // If index is within range, the letter at index should be removed from the hand (the location set to null) and the
    // letter that was at index returned.
    // If there is no letter at index, return null.

    /**
     * This is the Letter remove method.
     *
     * @param index is an int.
     * @return null.
     */

    public Letter remove(int index) {
        if (index < 0 || index >= hand.length) {
            return null;
        }
        Letter letter = hand[index];
        hand[index] = null;
        return letter;

    }

    // This method should search through the hand and return the index of the first occurrence of letter.
    // If the letter is not in the hand, return -1

    /**
     * One arg constructor with the parm of letter.
     *
     * @param letter is a character
     * @return -1
     */

    public int indexOf(char letter) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null && hand[i].getLetter() == letter) {
                return i;
            }
        }
        return -1;
    }

    // This method should return a String consisting of the following for each letter in the hand: index followed
    // immediately by a colon, then a space, then the Letter toString followed by a semicolon, and a final space. If
    // there is no letter at index, i.e. the location is null, then insert a dash ‘-’ where the letters toString would
    // be printed.
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < this.hand.length; i++) {
            string.append(i + ": ");
            if (this.hand[i] != null) {
                string.append(this.hand[i].toString());
            } else {
                string.append("-");
            }
            string.append("; ");
        }
        // hand = 'go'
        return string.toString();

    }
}
