package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassTest {
    @Test
    void position() {
        Grass grass = new Grass(new Vector2d(2, 3));
        assertEquals(new Vector2d(2, 3), grass.getPosition());
    }
}
