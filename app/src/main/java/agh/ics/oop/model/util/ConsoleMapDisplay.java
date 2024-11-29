package agh.ics.oop.model.util;

import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.WorldMap;

public class ConsoleMapDisplay implements MapChangeListener {
    private int moveCounter = 0;

    @Override
    public void mapChanged(WorldMap map, String message) {
        synchronized (System.out) {
            System.out.println(String.format("%d.move in map %s", moveCounter, map.getId()));
            System.out.println(message);
            System.out.println(map);
        }
    }
}
