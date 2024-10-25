package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println("system wystartował");
        run(OptionsParser.parse(args));
        System.out.println("system zakończył działanie");
    }


    static void run(MoveDirection[] args) {
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
