package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;


public class OptionsParser {
    public static ArrayList<MoveDirection> parse(String[] moves) {
        ArrayList<MoveDirection> moveList = new ArrayList<MoveDirection>();  // using ArrayList because program much more often gets elements by index than deletes or adds them
        for (String string : moves) {
            switch (string) {
                case "f" -> moveList.add(MoveDirection.FORWARD);
                case "b" -> moveList.add(MoveDirection.BACKWARD);
                case "l" -> moveList.add(MoveDirection.LEFT);
                case "r" -> moveList.add(MoveDirection.RIGHT);
            }
        }
        return moveList;
    }
}
