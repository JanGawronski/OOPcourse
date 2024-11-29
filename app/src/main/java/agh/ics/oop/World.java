package agh.ics.oop;

import agh.ics.oop.model.AbstractWorldMap;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.util.ConsoleMapDisplay;

import java.util.List;
import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
       
        if (args.length == 0)
            args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        List<MoveDirection> directions;
        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }

        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        List<Simulation> simulations = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            AbstractWorldMap map = i % 2 == 0 ? new RectangularMap(5, 5) : new GrassField(10);
            map.addObserver(new ConsoleMapDisplay());
            simulations.add(new Simulation(positions, directions, map));
        }

        SimulationEngine engine = new SimulationEngine(simulations);
        engine.runAsync();

        
        System.out.println("system zakończył działanie");
    }

}
