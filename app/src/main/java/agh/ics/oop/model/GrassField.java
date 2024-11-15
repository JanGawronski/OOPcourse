package agh.ics.oop.model;

import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class GrassField implements WorldMap {
    private final Map<Vector2d, Grass> map = new HashMap<>();
    private final Map<Vector2d, Animal> animals = new HashMap<>();

    public GrassField(int amountOfGrass) {
        Random random = new Random();
        int i = 0;
        while (i < amountOfGrass) {
            int x = random.nextInt((int) Math.sqrt(amountOfGrass) * 10);
            int y = random.nextInt((int) Math.sqrt(amountOfGrass) * 10);
            Vector2d position = new Vector2d(x, y);
            
            if (!map.containsKey(position)) {
                map.put(position, new Grass(position));
                i++;
            }

        }   

    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    

}
