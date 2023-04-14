/**
 * This is the letter class.
 * 
 * @author adins
 * @version 02-02-2023
 */
public class Letter {

    private char letter;
    private int points;

    /**
     * The letter method with two params.
     * 
     * @param letter is a charater
     * @param points is an int
     */

    public Letter(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * This is a method with a boolean return type.
     * 
     * @param other which is a character
     * @return the same point as letter and point
     */

    public boolean eaquals(Letter other) {

        return this.letter == other.letter && this.points == other.points;

    }

    @Override
    public String toString() {
        return "Letter: " + letter + " Points: " + points;
    }
}
