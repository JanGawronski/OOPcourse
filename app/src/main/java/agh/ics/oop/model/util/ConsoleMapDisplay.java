package agh.ics.oop.model.util;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {
    private int moveCounter = 0;

    @Override
    public void mapChanged(WorldMap map, String message) {
            System.out.println(moveCounter++ + ". move");
            System.out.println(message);
            System.out.println(map);
        }
}
