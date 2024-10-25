package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] moves) {
        int legalMoveCounter = 0;
        for (String string : moves) {
            if (string.equals("f") || string.equals("b") || string.equals("l") || string.equals("r"))
                legalMoveCounter++;
        }

        MoveDirection[] moveList = new MoveDirection[legalMoveCounter];
        int i = 0;
        for (String string : moves) {
            switch (string) {
                case "f":
                    moveList[i++] = MoveDirection.FORWARD;
                    break;
                case "b":
                    moveList[i++] = MoveDirection.BACKWARD;
                    break;
                case "l":
                    moveList[i++] = MoveDirection.LEFT;
                    break;
                case "r":
                    moveList[i++] = MoveDirection.RIGHT;
                    break;
            }
        }
        return moveList;
    }
}
