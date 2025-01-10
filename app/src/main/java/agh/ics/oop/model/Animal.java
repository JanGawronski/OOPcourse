package agh.ics.oop.model;

public class Animal implements WorldElement {
    private static final String[] DIRECTION_IMAGE_PATH = {
            "up.png",
            "down.png",
            "left.png",
            "right.png"
    };
    private static final String[] DIRECTION_STRING = {
            "^",
            "∨",
            "<",
            ">"
    };
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

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String getImageFileName() {
        return DIRECTION_IMAGE_PATH[orientation.ordinal()];
    }

    @Override
    public String toString() {
        return DIRECTION_STRING[orientation.ordinal()];
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
