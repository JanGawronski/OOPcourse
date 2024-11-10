package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

import agh.ics.oop.model.util.MapVisualizer;

public class RectangularMap implements WorldMap<Animal, Vector2d>{
    final private Map<Vector2d, Animal> animals = new HashMap<>();
    final private Vector2d upperRightBoundary;

    static final private Vector2d lowerLeftBoundary = new Vector2d(0,0);
    final private MapVisualizer mapVisualizer = new MapVisualizer(this);
    
    public RectangularMap(int width, int height) {
        upperRightBoundary = new Vector2d(width, height);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            return false;
        
        animals.put(animal.getPosition(), animal);

        return true;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        animals.remove(oldPosition);
        animals.put(animal.getPosition(), animal);
    }
    
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightBoundary) && position.follows(lowerLeftBoundary) && !isOccupied(position);
    }

    public String toString() {
        return mapVisualizer.draw(lowerLeftBoundary, upperRightBoundary);
    }
}
