package agh.ics.oop.model;

public class Grass implements WorldElement {
    private static final String IMAGE_FILE_NAME = "grass.png";
    private final Vector2d position;

    public Grass(Vector2d position){
        this.position = position;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String getImageFileName() {
        return IMAGE_FILE_NAME;
    }

    @Override
    public String toString() {
        return "*";
    }
}
