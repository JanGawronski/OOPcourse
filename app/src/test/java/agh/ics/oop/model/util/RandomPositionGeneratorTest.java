package agh.ics.oop.model.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.model.Vector2d;

public class RandomPositionGeneratorTest {
    @Test
    void count() {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(4, 4, 5);
        int count = 0;
        for (Vector2d position : randomPositionGenerator)
            count++;
        assertEquals(5, count);
    }

    @Test
    void tooMany() {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(2, 2, 5);
        int count = 0;
        for (Vector2d position : randomPositionGenerator)
            count++;
        assertEquals(4, count);
    }

    @Test
    void unique() {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(4, 4, 5);
        Vector2d[] positions = new Vector2d[5];
        int i = 0;
        for (Vector2d position : randomPositionGenerator)
            positions[i++] = position;
        for (int j = 0; j < 5; j++)
            for (int k = j + 1; k < 5; k++)
                assertNotEquals(positions[j], positions[k]);
    }

    @Test
    void inBounds() {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator(2, 4, 5);
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(1, 3);

        for (Vector2d position : randomPositionGenerator) {
            assertTrue(position.precedes(upperRight));
            assertTrue(position.follows(lowerLeft));
        }
    }

}
