package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class OptionsParserTest {

    @Test
    void parseSingleLetters() {
        assertEquals(OptionsParser.parse(new String[]{"f"}), List.of(MoveDirection.FORWARD));
        assertEquals(OptionsParser.parse(new String[]{"b"}), List.of(MoveDirection.BACKWARD));
        assertEquals(OptionsParser.parse(new String[]{"l"}), List.of(MoveDirection.LEFT));
        assertEquals(OptionsParser.parse(new String[]{"r"}), List.of(MoveDirection.RIGHT));
        assertEquals(OptionsParser.parse(new String[]{"_"}), new ArrayList<MoveDirection>());        
    }

    @Test
    void parseMultipleLetters() {
        assertEquals(OptionsParser.parse(new String[]{"f", "b", "l", "r", "_", "f", "f", "f"}), List.of(
            MoveDirection.FORWARD,
            MoveDirection.BACKWARD,
            MoveDirection.LEFT,
            MoveDirection.RIGHT,
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
            MoveDirection.FORWARD
        ));
    }

    @Test
    void parseIncorrectStrings() {
        assertEquals(OptionsParser.parse(new String[]{"abcdef", "", "should", "not", "work", "F", "B", "L", "R"}), new ArrayList<MoveDirection>());
    }   
}
