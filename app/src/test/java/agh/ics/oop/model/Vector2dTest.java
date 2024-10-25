package agh.ics.oop.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class Vector2dTest {
    @Test
    void testEquals() {
        Vector2d vector1 = new Vector2d(0, 1);
        assertTrue(new Vector2d(0, 1).equals(vector1));
        assertTrue(vector1.equals(vector1));
        assertFalse(vector1.equals(new Vector2d(1, 0)));
    }

    @Test
    void testToString() {
        assertEquals("(1,0)", new Vector2d(1, 0).toString());
    }

    @Test
    void precedes() {
        assertTrue(new Vector2d(0, 0).precedes(new Vector2d(0, 0)));
        assertTrue(new Vector2d(1, 0).precedes(new Vector2d(2, 1)));
        assertTrue(new Vector2d(1, 0).precedes(new Vector2d(1, 1)));
        assertFalse(new Vector2d(0, 0).precedes(new Vector2d(-1, 0)));
    }

    @Test
    void follows() {
        assertTrue(new Vector2d(0, 0).follows(new Vector2d(0, 0)));
        assertTrue(new Vector2d(2, 1).follows(new Vector2d(1, 0)));
        assertTrue(new Vector2d(1, 1).follows(new Vector2d(1, 0)));
        assertFalse(new Vector2d(-1, 0).follows(new Vector2d(0, 0)));
    }

    @Test
    void upperRight() {
        assertEquals(new Vector2d(1,2), new Vector2d(0, 0).upperRight(new Vector2d(1, 2)));
        assertEquals(new Vector2d(1, 2), new Vector2d(1, -1).upperRight(new Vector2d(0, 2)));
    }

    @Test
    void lowerLeft() {
        assertEquals(new Vector2d(1,2), new Vector2d(2, 3).lowerLeft(new Vector2d(1, 2)));
        assertEquals(new Vector2d(1, 2), new Vector2d(1, 3).lowerLeft(new Vector2d(4, 2)));
    }

    @Test
    void add() {
        assertEquals(new Vector2d(-1,2), new Vector2d(-2, 5).add(new Vector2d(1, -3)));
    }

    @Test
    void subtract() {
        assertEquals(new Vector2d(-1,2), new Vector2d(-2, 5).subtract(new Vector2d(-1, 3)));
    }

    @Test
    void opposite() {
        assertEquals(new Vector2d(-1,2), new Vector2d(1, -2).opposite());
    }

}
