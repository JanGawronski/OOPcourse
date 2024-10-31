package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import agh.ics.oop.OptionsParser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalTest {
    @Test
    void defaultSettings() {
        Animal animal = new Animal();
        assertEquals(new Vector2d(2, 2), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }

    @Test
    void assignedSettings() {
        final Vector2d vector = new Vector2d(0, -1);
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
        
        animal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }

    @Test
    void movementWithinBoundaries() {
        Animal animal = new Animal();
        
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), animal.getPosition());
        
        animal.move(MoveDirection.RIGHT);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 3), animal.getPosition());
        
    }

    @Test
    void animalDoesNotExceedBoundaries() {
        Animal animal = new Animal(new Vector2d(4, 4));
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 4), animal.getPosition());
        
        animal.move(MoveDirection.LEFT);
        animal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 4), animal.getPosition());
    }

    void inputInterpretationTestWithOptionsParser() {
        Animal animal = new Animal();
        String[] directions = {"f", "r", "f", "_", "f", "l", "b"};
        
        ArrayList<MoveDirection> moveList = OptionsParser.parse(directions);
        
        for (MoveDirection move : moveList)
            animal.move(move);
        
        assertEquals(new Vector2d(3, 3), animal.getPosition());
        assertEquals(MapDirection.NORTH, animal.getOrientation());
    }
}
