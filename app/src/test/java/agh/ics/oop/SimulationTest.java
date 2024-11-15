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
import java.util.Collections;


class SimulationTest {
    @Test
    void animalsInitialState() {
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(1, 2), new Vector2d(2, 3), new Vector2d(2, 2), new Vector2d(3, 3), new Vector2d(-1, -1));
        Simulation simulation = new Simulation(Collections.unmodifiableList(positions), new ArrayList<MoveDirection>(), new RectangularMap(4, 4));

        List<Animal> animals = simulation.getAnimals();

        assertEquals(positions.size() - 1, animals.size()); // one animal is not placed on the map

        for (int i = 0; i < animals.size(); i++) {
            assertEquals(positions.get(i), animals.get(i).getPosition());
            assertEquals(MapDirection.NORTH, animals.get(i).getOrientation());
        }
    }

    @Test
    void run() {
        List<MoveDirection> directions1 = List.of(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD);
        Simulation simulation1 = new Simulation(List.of(new Vector2d(1,0)), directions1, new RectangularMap(4, 4));
        simulation1.run(); 
        List<Animal> animals1 = simulation1.getAnimals();

        assertEquals(new Vector2d(3, 1), animals1.get(0).getPosition());
        assertEquals(MapDirection.EAST, animals1.get(0).getOrientation());


        List<MoveDirection> directions2 = List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD);
        Simulation simulation2 = new Simulation(List.of(new Vector2d(2,2), new Vector2d(2,3)), directions2, new RectangularMap(4, 4));
        simulation2.run(); 
        List<Animal> animals2 = simulation2.getAnimals();

        assertEquals(new Vector2d(3, 0), animals2.get(0).getPosition());
        assertEquals(MapDirection.SOUTH, animals2.get(0).getOrientation());

        assertEquals(new Vector2d(1, 3), animals2.get(1).getPosition());
        assertEquals(MapDirection.NORTH, animals2.get(1).getOrientation());
    }


}
