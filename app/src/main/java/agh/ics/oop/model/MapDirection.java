package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    static private final Vector2d northUnitVector = new Vector2d(0, 1);
    static private final Vector2d southUnitVector = new Vector2d(0, -1);
    static private final Vector2d westUnitVector = new Vector2d(-1, 0);
    static private final Vector2d eastUnitVector = new Vector2d(1, 0);

    public String toString() {
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }

    public MapDirection next() {
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        };
    }

    public MapDirection previous() {
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        };
    }

    public Vector2d toUnitVector() {
        return switch (this) {
            case NORTH -> northUnitVector;
            case SOUTH -> southUnitVector;
            case WEST -> westUnitVector;
            case EAST -> eastUnitVector;
        };   
    }
}
