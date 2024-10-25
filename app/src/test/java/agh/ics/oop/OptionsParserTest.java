package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class OptionsParserTest {

    @Test
    void parseSingleLetters() {
        assertArrayEquals(OptionsParser.parse(new String[]{"f"}), new MoveDirection[]{MoveDirection.FORWARD});
        assertArrayEquals(OptionsParser.parse(new String[]{"b"}), new MoveDirection[]{MoveDirection.BACKWARD});
        assertArrayEquals(OptionsParser.parse(new String[]{"l"}), new MoveDirection[]{MoveDirection.LEFT});
        assertArrayEquals(OptionsParser.parse(new String[]{"r"}), new MoveDirection[]{MoveDirection.RIGHT});
        assertArrayEquals(OptionsParser.parse(new String[]{"_"}), new MoveDirection[]{});        
    }

    @Test
    void parseMultipleLetters() {
        assertArrayEquals(OptionsParser.parse(new String[]{"f", "b", "l", "r", "_", "f", "f", "f"}), new MoveDirection[]{
            MoveDirection.FORWARD,
            MoveDirection.BACKWARD,
            MoveDirection.LEFT,
            MoveDirection.RIGHT,
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
        });
    }

    @Test
    void parseIncorrectStrings() {
        assertArrayEquals(OptionsParser.parse(new String[]{"abcdef", "", "should", "not", "work", "F", "B", "L", "R"}), new MoveDirection[]{});
    }   
}
