package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Animal> animals = new ArrayList<Animal>();
    private List<MoveDirection> directions; 

    public Simulation(List<Vector2d> positions, List<MoveDirection> directions) {
        for (Vector2d position : positions)
            animals.add(new Animal(position));
        this.directions = directions;
    }

    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            animals.get(i % animals.size()).move(directions.get(i));
            System.out.println(String.format("Zwierzę %d: %s", i % animals.size(), animals.get(i % animals.size())));
        }
    }


    
}
