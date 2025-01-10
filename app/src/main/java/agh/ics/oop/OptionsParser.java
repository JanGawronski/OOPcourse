package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class OptionsParser {
    public static List<MoveDirection> parse(String[] moves) {
        return Stream.of(moves)
                .map(move -> {
                    switch (move) {
                        case "f" -> {
                            return MoveDirection.FORWARD;
                        }
                        case "b" -> {
                            return MoveDirection.BACKWARD;
                        }
                        case "r" -> {
                            return MoveDirection.RIGHT;
                        }
                        case "l" -> {
                            return MoveDirection.LEFT;
                        }
                        default -> throw new IllegalArgumentException(move + " is not a legal move specification");
                    }
                })
                .collect(Collectors.toList());
    }
}