package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.exceptions.IncorrectPositionException;

import java.util.ArrayList;
import java.util.List;

public class Simulation implements Runnable{
    private final List<Animal> animals = new ArrayList<Animal>();
    private final List<MoveDirection> directions;
    private final WorldMap map;

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap map) {
        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            try {
                map.place(animal);
                animals.add(animal);
            } catch (IncorrectPositionException e) {
                // Ignoring exception and not adding animal to the map
            }
        }

        this.directions = directions;
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < directions.size(); i++)
            map.move(animals.get(i % animals.size()), directions.get(i));
    }

    List<Animal> getAnimals() {
        return new ArrayList<Animal>(animals);
    }
}
