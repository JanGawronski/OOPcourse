package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final List<Animal> animals = new ArrayList<Animal>(); // using ArrayList because program much more often gets elements by index than deletes or adds them
    private final List<MoveDirection> directions; 
    private final WorldMap map;

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions, WorldMap map) {
        for (Vector2d position : positions){
            Animal animal = new Animal(position);
            if(map.place(animal)){
                animals.add(animal);
            }
        }
        this.directions = directions;
        this.map = map;
    }

    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            map.move(animals.get(i % animals.size()), directions.get(i));
            System.out.println(map);
        }
    }

    List<Animal> getAnimals() { // package-private getter used only for testing
        return new ArrayList<Animal>(animals);
    }
}
