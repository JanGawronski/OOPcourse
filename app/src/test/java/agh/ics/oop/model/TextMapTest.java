package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TextMapTest {

    @Test
    void place() {
        TextMap textMap = new TextMap();
        assertTrue(textMap.place("Ala"));
        assertTrue(textMap.place("ma"));
        assertTrue(textMap.place("sowoniedźwiedzia"));
        assertEquals("Ala ma sowoniedźwiedzia", textMap.toString());
    }

    @Test
    void moveForward() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("sowoniedźwiedzia");
        textMap.move("Ala", MoveDirection.FORWARD);
        assertEquals("ma Ala sowoniedźwiedzia", textMap.toString());
    }

    @Test
    void moveBackward() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("sowoniedźwiedzia");
        textMap.move("sowoniedźwiedzia", MoveDirection.BACKWARD);
        assertEquals("Ala sowoniedźwiedzia ma", textMap.toString());
    }

    @Test
    void moveRight() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("sowoniedźwiedzia");
        textMap.move("ma", MoveDirection.RIGHT);
        assertEquals("Ala sowoniedźwiedzia ma", textMap.toString());
    }

    @Test
    void moveLeft() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("sowoniedźwiedzia");
        textMap.move("sowoniedźwiedzia", MoveDirection.LEFT);
        assertEquals("Ala sowoniedźwiedzia ma", textMap.toString());
    }

    @Test
    void isOccupied() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        assertTrue(textMap.isOccupied(0));
        assertFalse(textMap.isOccupied(1));
    }

    @Test
    void objectAt() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("sowoniedźwiedzia");
        assertEquals("Ala", textMap.objectAt(0));
        assertEquals("ma", textMap.objectAt(1));
        assertEquals("sowoniedźwiedzia", textMap.objectAt(2));
    }

    @Test
    void canMoveTo() {
        TextMap textMap = new TextMap();
        textMap.place("Ala");
        textMap.place("ma");
        textMap.place("sowoniedźwiedzia");
        assertFalse(textMap.canMoveTo(-1));
        assertTrue(textMap.canMoveTo(0));
        assertTrue(textMap.canMoveTo(1));
        assertTrue(textMap.canMoveTo(2));
        assertFalse(textMap.canMoveTo(3));
    }

}