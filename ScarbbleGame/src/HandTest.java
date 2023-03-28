import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * i.
 * 
 * @author stewarmc
 * @version s23
 */
class HandTest {

    /**
     * Test constructors for each condition specified.
     */
    @Test
    void testConstructors() {
        Hand h = new Hand();
        assertEquals(Hand.MAX_SIZE, h.getSize());

        h = new Hand(4);
        assertEquals(4, h.getSize());

        h = new Hand(-1);
        assertEquals(0, h.getSize());

        h = new Hand(9);
        assertEquals(8, h.getSize());
    }

    /**
     * Tests insert method.
     */
    @Test
    void testInsert() {
        Hand h = new Hand();
        Letter letter1 = new Letter('a', 2);
        assertTrue(h.insert(letter1, 0));
        assertEquals(letter1, h.getLetter(0));

        assertNull(h.getLetter(1));
    }

    /**
     * Tests insert method with bad index.
     */
    @Test
    void testInsertBadIndex() {
        Hand h = new Hand();
        Letter letter1 = new Letter('a', 2);
        assertFalse(h.insert(letter1, -1));
        assertFalse(h.insert(letter1, 8));
    }

    /**
     * Tests insert when hand is full.
     */
    @Test
    void testInsertFullSlot() {
        Hand h = new Hand();
        Letter letter1 = new Letter('a', 2);
        assertTrue(h.insert(letter1, 1));
        Letter letter2 = new Letter('b', 4);
        assertFalse(h.insert(letter2, 1));
        assertEquals(letter1, h.getLetter(1));
    }

    /**
     * Tests toString.
     */
    @Test
    void testToString() {
        Hand h = new Hand(2);
        h.insert(new Letter('x', 2), 0);
        assertEquals("0: Letter: x Points: 2; 1: -; ", h.toString());

        // This is Adin's understanding
        // It is talking in x as the character and 2 is the points and 1 is the length of the array
        // If hand = 'go' then toString should look like this

        // 0: Letter: g Points: 2; 1; -; "
        // 1: Letter: o Points: 2; 1; -: "

        // These are the directions
        // This method should return a String consisting of the following
        // for each letter in the hand:
        // index(of the array) followed
        // immediately by a colon(a string), then a space( a string), then the Letter(I will get by getLetter) toString
        // followed by a semicolon(a string), and a final space(which is a string). If
        // there is no letter at index, i.e. the location is null, then insert a dash ‘-’ where the letters
        // toString(which is the getLetter
        // would be printed.

        h = new Hand(2);
        h.insert(new Letter('g', 1), 0);
        h.insert(new Letter('o', 2), 1);
        // System.out.println(h.toString());
        assertEquals("0: Letter: g Points: 1; 1: Letter: o Points: 2; ", h.toString());
        // assertEquals("0: Letter: g Points: 1; 1: Letter: adin Points: 2;", h.toString());
        h = new Hand(2);
        h.insert(new Letter('g', 2), 0);
        assertEquals("0: Letter: g Points: 2; 1: -; ", h.toString());

        // 0: Letter: g Points: 1; 1: Letter: o Points: 2;
        // because we made 2 hand objects and the string we passed was 'go' and g is at index 0 and the point is 1
        // becasue its the first index and the same goes for the letter o but at index 1 and its the 2nd point

    }

    /**
     * Tests indexOf.
     */
    @Test
    void testIndexOf() {
        Hand h = new Hand();
        h.insert(new Letter('r', 2), 3);
        h.insert(new Letter('r', 2), 5);
        h.insert(new Letter('a', 5), 1);
        assertEquals(3, h.indexOf('r'));

        assertEquals(-1, h.indexOf('q'));
    }

    /**
     * Tests remove.
     */
    @Test
    void testRemove() {
        Hand h = new Hand();
        Letter letter1 = new Letter('r', 5);
        h.insert(letter1, 5);
        Letter removed = h.remove(5);
        assertNull(h.getLetter(5));
        assertEquals(letter1, removed);

        assertNull(h.remove(-1));
        assertNull(h.remove(8));
    }

}
