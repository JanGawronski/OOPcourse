package agh.ics.oop;

import org.junit.jupiter.api.Test;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class SimulationTest {
    @Test
    void pawnsInitialState() {
        List<Animal> animals = List.of(new Animal(new Vector2d(0, 0)), new Animal(new Vector2d(1, 2)), new Animal(new Vector2d(2, 3)), new Animal(new Vector2d(2, 2)), new Animal(new Vector2d(4, 4)));
        Simulation<Animal, Vector2d> simulation = new Simulation<Animal, Vector2d>(animals, new ArrayList<MoveDirection>(), new RectangularMap(4, 4));

        List<Animal> animalsFromSimulation = simulation.getPawns();

        assertEquals(animals.size(), animalsFromSimulation.size());

        for (int i = 0; i < animals.size(); i++) 
            assertEquals(animals.get(i), animalsFromSimulation.get(i));
    }

    @Test
    void run() {
        List<Animal> animals1 = List.of(new Animal(new Vector2d(1, 0)));
        List<MoveDirection> directions1 = List.of(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD);
        Simulation<Animal, Vector2d> simulation1 = new Simulation<Animal, Vector2d>(animals1, directions1, new RectangularMap(4, 4));
        simulation1.run(); 
        List<Animal> animalsFromSimulation1 = simulation1.getPawns();

        assertEquals(new Vector2d(3, 1), animalsFromSimulation1.get(0).getPosition());
        assertEquals(MapDirection.EAST, animals1.get(0).getOrientation());


        List<Animal> animals2 = List.of(new Animal(new Vector2d(2, 2)), new Animal(new Vector2d(3, 4)));
        List<MoveDirection> directions2 = List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT);
        Simulation<Animal, Vector2d> simulation2 = new Simulation<Animal, Vector2d>(animals2, directions2, new RectangularMap(4, 4));
        simulation2.run(); 
        List<Animal> animalsFromSimulation2 = simulation2.getPawns();

        assertEquals(new Vector2d(2, 3), animalsFromSimulation2.get(0).getPosition());
        assertEquals(MapDirection.SOUTH, animalsFromSimulation2.get(0).getOrientation());

        assertEquals(new Vector2d(3, 3), animalsFromSimulation2.get(1).getPosition());
        assertEquals(MapDirection.NORTH, animalsFromSimulation2.get(1).getOrientation());
    }


}
