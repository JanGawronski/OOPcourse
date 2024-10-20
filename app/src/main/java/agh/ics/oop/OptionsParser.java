package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        int legalMoveCounter = 0;
        for (String string : args) {
            if (string.equals("f") || string.equals("b") || string.equals("l") || string.equals("r"))
                legalMoveCounter++;
        }

        MoveDirection[] moves = new MoveDirection[legalMoveCounter];
        int i = 0;
        for (String string : args) {
            switch (string) {
                case "f":
                    moves[i] = MoveDirection.FORWARD;
                    i++;
                    break;
                case "b":
                    moves[i] = MoveDirection.BACKWARD;
                    i++;
                    break;
                case "l":
                    moves[i] = MoveDirection.LEFT;
                    i++;
                    break;
                case "r":
                    moves[i] = MoveDirection.RIGHT;
                    i++;
                    break;
                default:
                    break;
            }
        }
        return moves;
    }
}
