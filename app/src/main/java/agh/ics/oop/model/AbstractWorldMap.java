package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected final Map<Vector2d, Animal> animals = new HashMap<>();
    protected final MapVisualizer mapVisualizer = new MapVisualizer(this);
    
    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d oldPosition = animal.getPosition();
        animal.move(direction, this);
        animals.remove(oldPosition);
        animals.put(animal.getPosition(), animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition()))
            return false;
        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

    @Override
    public List<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position);
    }
}
