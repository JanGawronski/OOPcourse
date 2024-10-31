package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    static final private Vector2d lowerLeftBoundary = new Vector2d(0,0);
    static final private Vector2d upperRightBoundary = new Vector2d(4,4);

    public Animal() {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
    }

    public Animal(MapDirection orientation, Vector2d position) {
        this.orientation = orientation;
        this.position = position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return String.format("Zwierzę znajduje się na pozycji %s w kierunku %s", position.toString(), orientation.toString());
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case FORWARD: {
                Vector2d potentialPosition = position.add(orientation.toUnitVector());
                if (potentialPosition.precedes(lowerLeftBoundary) && potentialPosition.follows(upperRightBoundary))
                    position = potentialPosition;
                break;
            }
            case BACKWARD: {
                Vector2d potentialPosition = position.subtract(orientation.toUnitVector());
                if (potentialPosition.precedes(lowerLeftBoundary) && potentialPosition.follows(upperRightBoundary))
                    position = potentialPosition;
                break;
            }
            case LEFT:
                orientation = orientation.previous();
                break;
            case RIGHT:
                orientation = orientation.next();
                break;
        }
    }



}
