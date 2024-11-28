package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import agh.ics.oop.model.exceptions.IncorrectPositionException;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class GrassFieldTest {
    @Test
    void grassCount() {
        GrassField map = new GrassField(10);
        assertEquals(10, map.getElements().size());
    }

    @Test
    void inBounds() {
        GrassField map = new GrassField(10);
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(10, 10);
        for (WorldElement element : map.getElements()) {
            assertTrue(element.getPosition().precedes(upperRight));
            assertTrue(element.getPosition().follows(lowerLeft));
        }        
    }

    @Test
    void isOccupied() {
        GrassField map = new GrassField(10);
        for (WorldElement element : map.getElements())
            assertTrue(map.isOccupied(element.getPosition()));
        
        Animal[] animals = {new Animal(new Vector2d(1, 2)), new Animal(new Vector2d(3, 4))};
        for (Animal animal : animals) {
            assertDoesNotThrow(() -> map.place(animal));
            assertTrue(map.isOccupied(animal.getPosition()));
        }
    }

    @Test
    void objectAt() {
        GrassField map = new GrassField(10);
        for (WorldElement element : map.getElements())
            assertEquals(element, map.objectAt(element.getPosition()));
        
        Animal[] animals = {new Animal(new Vector2d(1, 2)), new Animal(new Vector2d(3, 4))};
        for (Animal animal : animals) {
            assertDoesNotThrow(() -> map.place(animal));
            assertEquals(animal, map.objectAt(animal.getPosition()));
        }
    }

    @Test
    void place() {
        GrassField map = new GrassField(10);
        Animal[] animals = {new Animal(new Vector2d(1, 2)), new Animal(new Vector2d(3, 4))};
        for (Animal animal : animals)
            assertDoesNotThrow(() -> map.place(animal));
        
        for (Animal animal : animals)
            assertThrowsExactly(IncorrectPositionException.class, () -> map.place(animal));
    }

    @Test
    void placeOnGrass() {
        GrassField map = new GrassField(10);
        Vector2d grassPosition = map.getElements().getFirst().getPosition();
        assertDoesNotThrow(() -> map.place(new Animal(grassPosition)));
    }

    @Test
    void move() {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(new Vector2d(1, 2));
        assertDoesNotThrow(() -> map.place(animal));
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(1, 3), animal.getPosition());
    }

    @Test
    void moveOutOfBounds() {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(new Vector2d(10, 10));
        assertDoesNotThrow(() -> map.place(animal));
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(10, 11), animal.getPosition());

        Animal animal2 = new Animal(new Vector2d(0, 0));
        assertDoesNotThrow(() -> map.place(animal2));
        map.move(animal2, MoveDirection.BACKWARD);
        assertEquals(new Vector2d(0, -1), animal2.getPosition());
    }

    @Test
    void moveOnAnimal() {
        GrassField map = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(1, 2));
        Animal animal2 = new Animal(new Vector2d(1, 3));
        assertDoesNotThrow(() -> map.place(animal1));
        assertDoesNotThrow(() -> map.place(animal2));
        map.move(animal1, MoveDirection.FORWARD);
        assertEquals(new Vector2d(1, 2), animal1.getPosition());
    }

    @Test
    void moveOnGrass() {
        GrassField map = new GrassField(10);
        Animal animal = new Animal(new Vector2d(1, 2));
        assertDoesNotThrow(() -> map.place(animal));
        map.move(animal, MoveDirection.FORWARD);
        assertEquals(new Vector2d(1, 3), animal.getPosition());
    }

    @Test
    void getCurrentBounds() {
        GrassField map = new GrassField(10);
        Boundary bounds1 = map.getCurrentBounds();

        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(0, 0);

        List<WorldElement> elements = map.getElements();
        for (WorldElement element : elements) {
            lowerLeft = lowerLeft.lowerLeft(element.getPosition());
            upperRight = upperRight.upperRight(element.getPosition());
        }


        assertEquals(lowerLeft, bounds1.lowerLeft());
        assertEquals(upperRight, bounds1.upperRight());

        Animal animal = new Animal(new Vector2d(100, 200));
        assertDoesNotThrow(() -> map.place(animal));
        Boundary bounds2 = map.getCurrentBounds();
        assertEquals(new Vector2d(0, 0), bounds2.lowerLeft());
        assertEquals(new Vector2d(100, 200), bounds2.upperRight());


        Animal animal2 = new Animal(new Vector2d(-50, -20));
        assertDoesNotThrow(() -> map.place(animal2));
        Boundary bounds3 = map.getCurrentBounds();
        assertEquals(new Vector2d(-50, -20), bounds3.lowerLeft());
        assertEquals(new Vector2d(100, 200), bounds3.upperRight());
    }


    @Test
    void getElements() {
        GrassField map = new GrassField(10);
        assertEquals(10, map.getElements().size());

        Animal animal = new Animal(new Vector2d(1, 2));
        assertDoesNotThrow(() -> map.place(animal));
        assertEquals(11, map.getElements().size());
        assertTrue(map.getElements().contains(animal));
    }
}
