package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.WorldMap;

import java.util.List;

public class Simulation<T, P> {
    private final List<T> pawns;
    private final List<MoveDirection> directions; 
    private final WorldMap<T, P> map;

    public Simulation(List<T> pawns, List<MoveDirection> directions, WorldMap<T, P> map) {
        this.pawns = pawns;
        for (T pawn : pawns)
            map.place(pawn);
        this.directions = directions;
        this.map = map;
    }

    public void run() {
        for (int i = 0; i < directions.size(); i++) {
            map.move(pawns.get(i % pawns.size()), directions.get(i));
            System.out.println(map);
        }
    }

    List<T> getPawns() {
        return pawns;
    }
}
