package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class AnimalTest {
    @Test
    void defaultSettings() {
        Animal animal = new Animal();
        assertEquals(new Vector2d(2, 2), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void assignedSettings() {
        Vector2d vector = new Vector2d(0, -1);
        Animal animal = new Animal(vector);
        assertEquals(vector, animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void orientationAfterTurning() {
        Animal animal = new Animal();

        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
        
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());
        
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, animal.getOrientation());
        
        animal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());
        
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, animal.getOrientation());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, animal.getOrientation());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, animal.getOrientation());

        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void positionAfterMoving() {
        Animal animal = new Animal(new Vector2d(1, 1));

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(1, 2), animal.getPosition());

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(1, 3), animal.getPosition());

        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(1, 2), animal.getPosition());

        animal.move(MoveDirection.RIGHT);
        assertEquals(new Vector2d(1, 2), animal.getPosition());

        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 2), animal.getPosition());

        animal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(1, 2), animal.getPosition());
    }

    @Test
    void staysWithinBounds() {
        Animal animal = new Animal(new Vector2d(0, 0));

        //animal check left border
        for (int i = 0; i <= 4; i++) {
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.FORWARD);
            assertEquals(new Vector2d(0, i), animal.getPosition());
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.LEFT);
            assertEquals(new Vector2d(0, i), animal.getPosition());
            animal.move(MoveDirection.FORWARD);
        }

        animal.move(MoveDirection.RIGHT);

        // animal checks top border
        for (int i = 0; i <= 4; i++) {
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.FORWARD);
            assertEquals(new Vector2d(i, 4), animal.getPosition());
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.LEFT);
            assertEquals(new Vector2d(i, 4), animal.getPosition());
            animal.move(MoveDirection.FORWARD);
        }

        animal.move(MoveDirection.RIGHT);

        // animal checks right border
        for (int i = 0; i <= 4; i++) {
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.FORWARD);
            assertEquals(new Vector2d(4, 4 - i), animal.getPosition());
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.LEFT);
            assertEquals(new Vector2d(4, 4 - i), animal.getPosition());
            animal.move(MoveDirection.FORWARD);
        }
        
        animal.move(MoveDirection.RIGHT);

        // animal checks bottom border
        for (int i = 0; i <= 4; i++) {
            animal.move(MoveDirection.LEFT);
            animal.move(MoveDirection.FORWARD);
            assertEquals(new Vector2d(4 - i, 0), animal.getPosition());
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.RIGHT);
            animal.move(MoveDirection.BACKWARD);
            animal.move(MoveDirection.LEFT);
            assertEquals(new Vector2d(4 - i, 0), animal.getPosition());
            animal.move(MoveDirection.FORWARD);
        }
    }

    @Test
    void isAt() {
        Animal animal = new Animal(new Vector2d(1, 0));
        assertTrue(animal.isAt(new Vector2d(1, 0)));

        assertFalse(animal.isAt(new Vector2d(0, 0)));
        assertFalse(animal.isAt(new Vector2d(0, 1)));

        animal.move(MoveDirection.FORWARD);
        assertTrue(animal.isAt(new Vector2d(1, 1)));
    }
}
