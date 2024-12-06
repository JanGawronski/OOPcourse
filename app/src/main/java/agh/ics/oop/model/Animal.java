package agh.ics.oop.model;

public class Animal implements WorldElement {
    private MapDirection orientation;
    private Vector2d position;

    static final private Vector2d defaultPostion = new Vector2d(2, 2);

    public Animal() {
        this(defaultPostion);
    }

    public Animal(Vector2d position) {
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "^";
            case SOUTH -> "∨";
            case WEST -> "<";
            case EAST -> ">";
        };

    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator moveValidator) {
        switch (direction) {
            case FORWARD: {
                Vector2d potentialPosition = position.add(orientation.toUnitVector());
                if (moveValidator.canMoveTo(potentialPosition))
                    position = potentialPosition;
                break;
            }
            case BACKWARD: {
                Vector2d potentialPosition = position.subtract(orientation.toUnitVector());
                if (moveValidator.canMoveTo(potentialPosition))
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
