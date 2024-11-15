package agh.ics.oop.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> map = new HashMap<>();

    public GrassField(int amountOfGrass) {
        Random random = new Random();
        int i = 0;
        while (i < amountOfGrass) {
            int x = random.nextInt((int) Math.sqrt(amountOfGrass) * 10);
            int y = random.nextInt((int) Math.sqrt(amountOfGrass) * 10);
            Vector2d position = new Vector2d(x, y);
            
            if (!isOccupied(position)) {
                map.put(position, new Grass(position));
                i++;
            }
        }  
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || map.get(position) != null;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.objectAt(position) != null)
            return super.objectAt(position);
        return map.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return animals.get(position) == null;
    }

    public String toString() {
        Vector2d upperRight = map.keySet().iterator().next();
        Vector2d lowerLeft = upperRight;

        for (Vector2d position : map.keySet()) {
            if (position.precedes(lowerLeft))
                lowerLeft = position;
            if (position.follows(upperRight))
                upperRight = position;
        }

        for (Vector2d position : animals.keySet()) {
            if (position.precedes(lowerLeft))
                lowerLeft = position;
            if (position.follows(upperRight))
                upperRight = position;
        }

        return mapVisualizer.draw(lowerLeft, upperRight);
    }
    
    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(new ArrayList<>(map.values()));
        return elements;
    }
}