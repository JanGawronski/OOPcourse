package agh.ics.oop;

import agh.ics.oop.model.AbstractWorldMap;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.util.ConsoleMapDisplay;
import agh.ics.oop.model.util.FileMapDisplay;

import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");

        if (args.length == 0)
            args = new String[] { "f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f" };

        List<MoveDirection> directions;
        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return;
        }

        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        List<Simulation> simulations = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            AbstractWorldMap map = i % 2 == 0 ? new RectangularMap(5, 5) : new GrassField(10);
            map.addObserver(new ConsoleMapDisplay());
            map.addObserver((map1, message) -> System.out.println(DateFormat.getDateTimeInstance().format(new Date()) + " " + message));
            map.addObserver(new FileMapDisplay());
            simulations.add(new Simulation(positions, directions, map));
        }

        SimulationEngine engine = new SimulationEngine(simulations);
        engine.runAsyncInThreadPool();
        try {
            engine.awaitSimulationsEnd();
        } catch (InterruptedException e) {
            // Thread was interrupted, ignoring exception
        }
        System.out.println("system zakończył działanie");
    }

}
