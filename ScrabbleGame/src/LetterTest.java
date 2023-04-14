import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Letter class.
 * 
 * @author stewarmc
 * @version s23
 */
class LetterTest {

    /**
     * Tests constructor.
     */
    @Test
    void testConstructor() {
        Letter x = new Letter('x', 7);
        assertEquals('x', x.getLetter());
        assertEquals(7, x.getPoints());
    }

    /**
     * Tests equals.
     */
    @Test
    void testEquals() {
        Letter x = new Letter('x', 7);
        Letter y = new Letter('y', 2);
        Letter z = new Letter('z', 7);
        Letter x2 = new Letter('x', 3);

        assertTrue(x.equals(x));
        assertFalse(x.equals(y));
        assertFalse(x.equals(z));
        assertFalse(x.equals(x2));
    }

    /**
     * Tests toString.
     */
    @Test
    void testToString() {
        Letter x = new Letter('x', 7);
        assertEquals("Letter: x Points: 7", x.toString());
    }

}
