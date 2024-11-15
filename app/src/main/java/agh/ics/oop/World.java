package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.RectangularMap;
import agh.ics.oop.model.Vector2d;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
       
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, new RectangularMap(4, 4));
        simulation.run(); 

        System.out.println("system zakończył działanie");
    }

}
