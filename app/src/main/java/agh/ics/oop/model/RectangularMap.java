package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {
    final private Vector2d upperRightBoundary;
    static final private Vector2d lowerLeftBoundary = new Vector2d(0,0);
    
    public RectangularMap(int width, int height) {
        upperRightBoundary = new Vector2d(width - 1, height - 1);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(upperRightBoundary) && position.follows(lowerLeftBoundary) && !isOccupied(position);
    }

    public String toString() {
        return mapVisualizer.draw(lowerLeftBoundary, upperRightBoundary);
    }
}
