package agh.ics.oop;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.util.ConsoleMapDisplay;
import java.util.List;

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
        GrassField map = new GrassField(10);
        map.addObserver(new ConsoleMapDisplay());
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run(); 

        System.out.println("system zakończył działanie");
    }

}
