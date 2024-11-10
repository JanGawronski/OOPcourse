package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.TextMap;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");

        if (args.length == 0)
            args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};

        List<MoveDirection> directions = OptionsParser.parse(args);
        Simulation<String, Integer> simulation = new Simulation<String, Integer>(List.of("Ala", "ma", "sowoniedźwiedzia", "a", "sowoniedźwiedź", "Alę"), directions, new TextMap());
        simulation.run(); 

        System.out.println("system zakończył działanie");
    }

}
