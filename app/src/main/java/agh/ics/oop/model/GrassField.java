package agh.ics.oop.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import agh.ics.oop.model.util.RandomPositionGenerator;

public class GrassField extends AbstractWorldMap {
    private final Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int grassCount) {
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int)Math.sqrt(grassCount * 10) + 1, (int)Math.sqrt(grassCount * 10) + 1, grassCount);
        for(Vector2d grassPosition : randomPositionGenerator) 
            grasses.put(grassPosition, new Grass(grassPosition));
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.objectAt(position) != null)
            return super.objectAt(position);
        return grasses.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || grasses.containsKey(position);
    }

    public String toString() {
        List<WorldElement> elements = getElements();
        if (elements.isEmpty())
            return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(0, 0));

        Vector2d lowerLeft = elements.getFirst().getPosition();
        Vector2d upperRight = elements.getFirst().getPosition();

        for (WorldElement element : elements) { 
            lowerLeft = lowerLeft.lowerLeft(element.getPosition());
            upperRight = upperRight.upperRight(element.getPosition());
        }

        return mapVisualizer.draw(lowerLeft, upperRight);
    }
    
    @Override
    public List<WorldElement> getElements() {
        List<WorldElement> elements = super.getElements();
        elements.addAll(new ArrayList<>(grasses.values()));
        return elements;
    }
}