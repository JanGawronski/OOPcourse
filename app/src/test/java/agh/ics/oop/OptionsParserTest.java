package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class OptionsParserTest {

    @Test
    void parseSingleLetters() {
        assertEquals(List.of(MoveDirection.FORWARD), OptionsParser.parse(new String[]{"f"}));
        assertEquals(List.of(MoveDirection.BACKWARD), OptionsParser.parse(new String[]{"b"}));
        assertEquals(List.of(MoveDirection.LEFT), OptionsParser.parse(new String[]{"l"}));
        assertEquals(List.of(MoveDirection.RIGHT), OptionsParser.parse(new String[]{"r"}));
        assertEquals(new ArrayList<MoveDirection>(), OptionsParser.parse(new String[]{"_"}));        
    }

    @Test
    void parseMultipleLetters() {
        assertEquals(List.of(
            MoveDirection.FORWARD,
            MoveDirection.BACKWARD,
            MoveDirection.LEFT,
            MoveDirection.RIGHT,
            MoveDirection.FORWARD,
            MoveDirection.FORWARD,
            MoveDirection.FORWARD
        ), OptionsParser.parse(new String[]{"f", "b", "l", "r", "_", "f", "f", "f"}));
    }

    @Test
    void parseIncorrectStrings() {
        assertEquals(new ArrayList<MoveDirection>(), OptionsParser.parse(new String[]{"abcdef", "", "should", "not", "work", "F", "B", "L", "R"}));
    }   
}
