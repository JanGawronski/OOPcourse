package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    void place() {
        Animal animal = new Animal(new Vector2d(2, 3));
        WorldMap map = new RectangularMap(4, 4);

        assertTrue(map.place(animal));
        assertFalse(map.place(animal));
    }


    @Test
    void objectAt() {
        final Vector2d position = new Vector2d(2, 3);
        Animal animal = new Animal(position);
        WorldMap map = new RectangularMap(4, 4);

        map.place(animal);

        assertEquals(animal, map.objectAt(position));

        assertEquals(null, map.objectAt(new Vector2d(0, 0)));
        assertEquals(null, map.objectAt(new Vector2d(3, 1)));
        assertEquals(null, map.objectAt(new Vector2d(4, 4)));
    }

    @Test
    void isOccupied() {
        final Vector2d position = new Vector2d(2, 3);
        Animal animal = new Animal(position);
        WorldMap map = new RectangularMap(4, 4);

        map.place(animal);

        assertTrue(map.isOccupied(position));

        assertFalse(map.isOccupied(new Vector2d(0, 0)));
        assertFalse(map.isOccupied(new Vector2d(3, 1)));
        assertFalse(map.isOccupied(new Vector2d(4, 4)));
    }


    @Test 
    void placeMultiple() {
        Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 3), new Vector2d(3, 3)};
        Animal[] animals = {new Animal(positions[0]), new Animal(positions[1]), new Animal(positions[2]), new Animal(positions[3])};
        WorldMap map = new RectangularMap(4, 4);

        assertTrue(map.place(animals[0]));
        assertTrue(map.place(animals[1]));
        assertTrue(map.place(animals[2]));
        assertFalse(map.place(animals[2]));
        assertTrue(map.place(animals[3]));
        assertFalse(map.place(animals[0]));


        for (int i = 0; i < animals.length; i++) 
            assertEquals(animals[i], map.objectAt(positions[i]));
    

        assertEquals(null, map.objectAt(new Vector2d(0, 1)));
        assertEquals(null, map.objectAt(new Vector2d(3, 1)));
        assertEquals(null, map.objectAt(new Vector2d(4, 3)));
        

        for (Vector2d position : positions) 
            assertTrue(map.isOccupied(position));
    
        assertFalse(map.isOccupied(new Vector2d(3, 2)));
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        assertFalse(map.isOccupied(new Vector2d(2, 4)));

    }


    void canMoveTo() {
        Vector2d[] positions = {new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(2, 3), new Vector2d(4, 4)};
        Animal[] animals = {new Animal(positions[0]), new Animal(positions[1]), new Animal(positions[2]), new Animal(positions[3])};
        WorldMap map = new RectangularMap(4, 4);

        for (Animal animal : animals) 
            map.place(animal);
        
        for (Vector2d position : positions) 
            assertFalse(map.canMoveTo(position));
        
        assertTrue(map.canMoveTo(new Vector2d(3, 2)));
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(2, 4)));

        assertFalse(map.canMoveTo(new Vector2d(100, 0)));
        assertFalse(map.canMoveTo(new Vector2d(5, 5)));
        assertFalse(map.canMoveTo(new Vector2d(-1, 2)));
    }


    @Test
    public void testMove(){
        RectangularMap map = new RectangularMap(4, 4);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(3, 2));
        map.place(animal1);
        map.place(animal2);

        map.move(animal1, MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal1.getPosition());

        map.move(animal1, MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2, 2), animal1.getPosition());

        map.move(animal1, MoveDirection.RIGHT);
        assertEquals(new Vector2d(2, 2), animal1.getPosition());


        map.move(animal2, MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 3), animal2.getPosition());


        map.move(animal1, MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 2), animal1.getPosition());
    }
}
