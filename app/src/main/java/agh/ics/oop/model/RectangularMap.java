package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class RectangularMap implements WorldMap{
    private Map<Vector2d, Animal> animals = new HashMap<>();
    final private Vector2d upperRightBoundary;

    static final private Vector2d lowerLeftBoundary = new Vector2d(0,0);
    
    public RectangularMap(int width, int height) {
        upperRightBoundary = new Vector2d(width, height);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition()))
            return false;
        
        animals.put(animal.getPosition(), animal);

        return true;
    }

    public void move(Animal animal, MoveDirection direction) {
        
    }
    
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightBoundary) && position.follows(lowerLeftBoundary) && !isOccupied(position);
    }
}
