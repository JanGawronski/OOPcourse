package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");

        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run(); 

        Animal animal = new Animal();
        System.out.println(animal);
        
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        
        MapDirection direction1 = MapDirection.NORTH;
        System.out.println(direction1.toString());
        MapDirection direction2 = direction1.next();
        MapDirection direction3 = direction1.previous();
        System.out.println(direction2.toString());
        System.out.println(direction3.toString());
        System.out.println(direction1.toUnitVector().toString());

        
        run(OptionsParser.parse(args));
        System.out.println("system zakończył działanie");
    }


    private static void run(List<MoveDirection> args) {
        for (MoveDirection moveDirection : args) {
            switch (moveDirection) {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
            }
        }
    }
}
