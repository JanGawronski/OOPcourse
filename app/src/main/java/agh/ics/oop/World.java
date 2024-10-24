package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.OptionsParser;

public class World {
    public static void main(String[] args) {
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
